package com.winterflame.aura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterflame.aura.dto.VibeRequestDTO;
import com.winterflame.aura.entity.User;
import com.winterflame.aura.entity.Vibe;
import com.winterflame.aura.repository.UserRepository;
import com.winterflame.aura.repository.VibeRepository;

import jakarta.transaction.Transactional;

@Service
public class VibeService {

    private final VibeRepository vibeRepository;
    private final UserRepository userRepository;
    // private final VibeRepository vibeRepository;

    @Autowired
    public VibeService(VibeRepository vibeRepository, UserRepository userRepository) {
        this.vibeRepository = vibeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public int saveVibe(VibeRequestDTO vibeRequest) {

        User user = userRepository.getById(vibeRequest.getUserId());

        Vibe vibe = new Vibe();
        vibe.setUser(user);
        vibe.setDate(vibeRequest.getDate());
        return vibeRepository.save(vibe);
    }

}
