package com.winterflame.aura.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.winterflame.aura.entity.Pulse;
import com.winterflame.aura.entity.User;

public interface PulseRepository extends JpaRepository<Pulse, Integer> {

    @Query("SELECT p FROM Pulse p WHERE FUNCTION('YEAR', p.pulse_date)=:year AND p.user=:user ORDER BY p.date")
    List<Pulse> findByUserAndYearOrderByDate(int year, User user);

    @Query("SELECT p FROM Pulse p WHERE FUNCTION('YEAR', p.pulse_date)=:year AND FUNCTION('MONTH', p.pulse_date)=:month AND p.user=:user ORDER BY p.date")
    List<Pulse> findByUserAndYearAndMonthOrderByDate(int year, int month, User user);

    Pulse findByUserAndPulseDate(User user, LocalDate pulseDate);
}
