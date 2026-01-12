package com.winterflame.aura.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vibe")
public class Vibe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "rating_id", nullable = false)
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Vibe() {
    }

    public Vibe(LocalDate date, Rating rating, User user) {
        this.date = date;
        this.rating = rating;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Vibe{" +
                "id=" + id +
                ", date=" + date +
                ", ratingId=" + (rating != null ? rating.getId() : null) +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }

}
