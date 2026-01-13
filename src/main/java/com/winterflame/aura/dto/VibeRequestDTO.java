package com.winterflame.aura.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class VibeRequestDTO {

    private LocalDateTime dateTime;
    private int userId;
    private int ratingId;
    private boolean hasNotes;
    private Integer mentalRating;
    private Integer physicalRating;
    private String mentalHealthNotes;
    private String physicalHealthNotes;
    private String wins;
    private String setbacks;

    public VibeRequestDTO() {
    }

    public VibeRequestDTO(LocalDateTime dateTime, int userId, int ratingId, boolean hasNotes,
                          Integer mentalRating, Integer physicalRating, String mentalHealthNotes,
                          String physicalHealthNotes, String wins, String setbacks) {
        this.dateTime = dateTime;
        this.userId = userId;
        this.ratingId = ratingId;
        this.hasNotes = hasNotes;
        this.mentalRating = mentalRating;
        this.physicalRating = physicalRating;
        this.mentalHealthNotes = mentalHealthNotes;
        this.physicalHealthNotes = physicalHealthNotes;
        this.wins = wins;
        this.setbacks = setbacks;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public boolean getHasNotes() {
        return hasNotes;
    }

    public void setHasNotes(boolean hasNotes) {
        this.hasNotes = hasNotes;
    }

    public Integer getMentalRating() {
        return mentalRating;
    }

    public void setMentalRating(Integer mentalRating) {
        this.mentalRating = mentalRating;
    }

    public Integer getPhysicalRating() {
        return physicalRating;
    }

    public void setPhysicalRating(Integer physicalRating) {
        this.physicalRating = physicalRating;
    }

    public String getMentalHealthNotes() {
        return mentalHealthNotes;
    }

    public void setMentalHealthNotes(String mentalHealthNotes) {
        this.mentalHealthNotes = mentalHealthNotes;
    }

    public String getPhysicalHealthNotes() {
        return physicalHealthNotes;
    }

    public void setPhysicalHealthNotes(String physicalHealthNotes) {
        this.physicalHealthNotes = physicalHealthNotes;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getSetbacks() {
        return setbacks;
    }

    public void setSetbacks(String setbacks) {
        this.setbacks = setbacks;
    }
}
