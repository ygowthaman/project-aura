package com.winterflame.aura.dto;

import java.time.LocalDateTime;

public class VibeRequestDTO {

    private LocalDateTime date;
    private int userId;
    private int panoramaId;

    public VibeRequestDTO(LocalDateTime date, int userId, int panoramaId) {
        this.date = date;
        this.userId = userId;
        this.panoramaId = panoramaId;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getPanoramaId() {
        return this.panoramaId;
    }
}
