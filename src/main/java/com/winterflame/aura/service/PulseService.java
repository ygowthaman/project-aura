package com.winterflame.aura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterflame.aura.entity.Pulse;
import com.winterflame.aura.entity.User;
import com.winterflame.aura.repository.PulseRepository;
import com.winterflame.aura.repository.SqlErrorException;
import com.winterflame.aura.repository.UserRepository;

@Service
public class PulseService {

    private PulseRepository pulseRepository;
    private UserRepository userRepository;

    @Autowired
    public PulseService(PulseRepository pulseRepository, UserRepository userRepository) {
        this.pulseRepository = pulseRepository;
        this.userRepository = userRepository;
    }

    public Pulse getPulseById(int pulseId) {
        Optional<Pulse> result = pulseRepository.findById(pulseId);
        Pulse pulse = null;

        if (result.isPresent()) {
            pulse = result.get();
        } else {
            throw new SqlErrorException("Record not found");
        }

        return pulse;
    }

    public List<Pulse> getPulseByYearAndUser(int year, int userId) {
        User user = userRepository.getById(userId);
        return pulseRepository.findByUserAndYearOrderByDate(year, user);
    }

    public List<Pulse> getPulseByYearMonthUser(int year, int month, int userId) {
        User user = userRepository.getById(userId);
        return pulseRepository.findByUserAndYearAndMonthOrderByDate(year, month, user);
    }

    public Pulse getPulseByDateAndUser(int userId, LocalDate date) {
        User user = userRepository.getById(userId);
        return pulseRepository.findByUserAndPulseDate(user, date);
    }
}
