package com.winterflame.aura.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "vibe", uniqueConstraints = @UniqueConstraint(columnNames = { "date" }))
public class Vibe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vibe_id")
    private int vibeId;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "rating_id", nullable = false)
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Transient
    private DayHealth dayHealth;

    @Transient
    private boolean hasNotes;

    public Vibe() {
    }

    public Vibe(LocalDate date, Rating rating, User user) {
        this.date = date;
        this.rating = rating;
        this.user = user;
    }

    public int getVibeId() {
        return vibeId;
    }

    public void setVibeId(int id) {
        this.vibeId = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DayHealth getDayHealth() {
        return dayHealth;
    }

    public void setDayHealth(DayHealth dayHealth) {
        this.dayHealth = dayHealth;
    }

    public boolean isHasNotes() {
        return hasNotes;
    }

    public void setHasNotes(boolean hasNotes) {
        this.hasNotes = hasNotes;
    }

    @Override
    public String toString() {
        return "Vibe{" +
                "vibeId=" + vibeId +
                ", date=" + date +
                ", ratingId=" + (rating != null ? rating.getRatingId() : null) +
                ", userId=" + (user != null ? user.getUserId() : null) +
                '}';
    }

}
