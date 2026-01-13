package com.winterflame.aura.service;

import com.winterflame.aura.entity.DayHealth;
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
        // Fetch required entities with null checks
        User user = userRepository.getById(vibeRequest.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + vibeRequest.getUserId());
        }

        Rating rating = ratingRepository.getById(vibeRequest.getRatingId());
        if (rating == null) {
            throw new IllegalArgumentException("Rating not found with id: " + vibeRequest.getRatingId());
        }

        // Check if vibe already exists for this date and user
        Vibe vibe = vibeRepository.getByDateForUser(vibeRequest.getDate(), user);
        boolean isNewVibe = (vibe == null);

        if (isNewVibe) {
            vibe = new Vibe();
            vibe.setUser(user);
        }

        // Update vibe properties
        vibe.setDate(vibeRequest.getDate());
        vibe.setRating(rating);
        vibe.setHasNotes(Boolean.TRUE.equals(vibeRequest.getHasNotes()));

        // Handle dayHealth if notes are present
        if (Boolean.TRUE.equals(vibeRequest.getHasNotes())) {
            DayHealth dayHealth = buildDayHealth(vibeRequest, vibe);
            vibe.setDayHealth(dayHealth);
        } else {
            vibe.setDayHealth(null);
        }

        // Save or update
        return isNewVibe ? vibeRepository.save(vibe) : vibeRepository.update(vibe);
    }

    private DayHealth buildDayHealth(VibeRequestDTO vibeRequest, Vibe existingVibe) {
        // Get existing dayHealth if updating, otherwise create new
        DayHealth dayHealth = (existingVibe != null && existingVibe.getDayHealth() != null)
                ? existingVibe.getDayHealth()
                : new DayHealth();

        // Set mental rating if provided
        if (vibeRequest.getMentalRating() != null && vibeRequest.getMentalRating() > 0) {
            Rating mentalRating = ratingRepository.getById(vibeRequest.getMentalRating());
            if (mentalRating == null) {
                throw new IllegalArgumentException("Mental rating not found with id: " + vibeRequest.getMentalRating());
            }
            dayHealth.setMentalRating(mentalRating);
        }

        // Set physical rating if provided
        if (vibeRequest.getPhysicalRating() != null && vibeRequest.getPhysicalRating() > 0) {
            Rating physicalRating = ratingRepository.getById(vibeRequest.getPhysicalRating());
            if (physicalRating == null) {
                throw new IllegalArgumentException(
                        "Physical rating not found with id: " + vibeRequest.getPhysicalRating());
            }
            dayHealth.setPhysicalRating(physicalRating);
        }

        // Set text fields if provided (now only need to check for empty)
        if (!vibeRequest.getMentalHealthNotes().isEmpty()) {
            dayHealth.setMentalHealthNotes(vibeRequest.getMentalHealthNotes());
        }

        if (!vibeRequest.getPhysicalHealthNotes().isEmpty()) {
            dayHealth.setPhysicalHealthNotes(vibeRequest.getPhysicalHealthNotes());
        }

        if (!vibeRequest.getWins().isEmpty()) {
            dayHealth.setWins(vibeRequest.getWins());
        }

        if (!vibeRequest.getSetbacks().isEmpty()) {
            dayHealth.setSetbacks(vibeRequest.getSetbacks());
        }

        return dayHealth;
    }

    public List<Vibe> getVibes(int userId) {
        User user = userRepository.getById(userId);
        return vibeRepository.getAll(user);
    }

    public List<Vibe> getVibesForYearByUser(int year, int userId) {
        User user = userRepository.getById(userId);
        return vibeRepository.getVibesForYearByUser(year, user);
    }

    public List<Vibe> getVibesForMonthByUser(int year, int month, int userId) {
        User user = userRepository.getById(userId);
        return vibeRepository.getVibesForMonthByUser(month, year, user);
    }

}
