package com.winterflame.aura.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VibeRequestDTO {

    private final LocalDateTime dateTime;
    private final int userId;
    private final int ratingId;

    public VibeRequestDTO(LocalDateTime dateTime, int userId, int ratingId) {
        this.dateTime = dateTime;
        this.userId = userId;
        this.ratingId = ratingId;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public int getUserId() {
        return userId;
    }

    public int getRatingId() {
        return ratingId;
    }
}
