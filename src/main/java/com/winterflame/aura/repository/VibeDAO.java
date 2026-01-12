package com.winterflame.aura.repository;

import java.time.LocalDate;
import java.util.List;

import com.winterflame.aura.entity.User;
import com.winterflame.aura.entity.Vibe;

public interface VibeDAO {

    int save(Vibe vibe);

    int update(Vibe vibe);

    void delete(int vibeId);

    List<Vibe> getAll();

    Vibe getById(int vibeId);

    Vibe getByDateAndUser(LocalDate date, User user);
}
