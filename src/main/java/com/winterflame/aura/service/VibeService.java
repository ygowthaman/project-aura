package com.winterflame.aura.service;

import com.winterflame.aura.entity.Rating;
import com.winterflame.aura.repository.RatingRepository;

import java.util.List;

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
    private final RatingRepository ratingRepository;

    @Autowired
    public VibeService(VibeRepository vibeRepository, UserRepository userRepository,
            RatingRepository ratingRepository) {
        this.vibeRepository = vibeRepository;
        this.userRepository = userRepository;
        this.ratingRepository = ratingRepository;
    }

    @Transactional
    public int saveVibe(VibeRequestDTO vibeRequest) {
        User user = userRepository.getById(vibeRequest.getUserId());
        Rating rating = ratingRepository.getById(vibeRequest.getRatingId());
        Vibe vibe = vibeRepository.getByDateAndUser(vibeRequest.getDate(), user);

        if (vibe == null) {
            vibe = new Vibe();
        }
        vibe.setUser(user);
        vibe.setDate(vibeRequest.getDate());
        vibe.setRating(rating);

        if (vibe.getId() == 0) {
            return vibeRepository.save(vibe);
        } else {
            return vibeRepository.update(vibe);
        }
    }

    public List<Vibe> getVibes() {
        return vibeRepository.getAll();
    }

}
