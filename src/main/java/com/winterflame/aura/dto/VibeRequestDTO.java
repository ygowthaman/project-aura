package com.winterflame.aura.dto;

import java.time.LocalDateTime;

public class VibeRequestDTO {

    private LocalDateTime date;
    private int userId;
    private int ratingId;

    public VibeRequestDTO(LocalDateTime date, int userId, int ratingId) {
        this.date = date;
        this.userId = userId;
        this.ratingId = ratingId;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getRatingId() {
        return this.ratingId;
    }
}
