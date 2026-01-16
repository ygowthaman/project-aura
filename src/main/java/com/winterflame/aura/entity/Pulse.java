package com.winterflame.aura.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "pulse", uniqueConstraints = @UniqueConstraint(columnNames = { "pulse_date" }))
public class Pulse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pulse_id")
    private int pulseId;

    @Column(name = "pulse_date")
    private LocalDate pulseDate;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "rating_id", nullable = false)
    private Rating rating;

    @ManyToOne()
    @JoinColumn(name = "mental_rating_id")
    private Rating mentalRating;

    @ManyToOne()
    @JoinColumn(name = "physical_rating_id")
    private Rating physicalRating;

    @Column(name = "mental_rating_notes")
    private String mentalRatingNotes;

    @Column(name = "physical_rating_notes")
    private String physicalRatingNotes;

    @Column(name = "triumphs")
    private String triumphs;

    @Column(name = "setbacks")
    private String setbacks;

    // Constructors
    public Pulse() {
    }

    public Pulse(int pulseId, LocalDate pulseDate, User user, Rating rating, Rating mentalRating, 
                 Rating physicalRating, String mentalRatingNotes, String physicalRatingNotes, 
                 String triumphs, String setbacks) {
        this.pulseId = pulseId;
        this.pulseDate = pulseDate;
        this.user = user;
        this.rating = rating;
        this.mentalRating = mentalRating;
        this.physicalRating = physicalRating;
        this.mentalRatingNotes = mentalRatingNotes;
        this.physicalRatingNotes = physicalRatingNotes;
        this.triumphs = triumphs;
        this.setbacks = setbacks;
    }

    // Getters and Setters
    public int getPulseId() {
        return pulseId;
    }

    public void setPulseId(int pulseId) {
        this.pulseId = pulseId;
    }

    public LocalDate getPulseDate() {
        return pulseDate;
    }

    public void setPulseDate(LocalDate pulseDate) {
        this.pulseDate = pulseDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Rating getMentalRating() {
        return mentalRating;
    }

    public void setMentalRating(Rating mentalRating) {
        this.mentalRating = mentalRating;
    }

    public Rating getPhysicalRating() {
        return physicalRating;
    }

    public void setPhysicalRating(Rating physicalRating) {
        this.physicalRating = physicalRating;
    }

    public String getMentalRatingNotes() {
        return mentalRatingNotes;
    }

    public void setMentalRatingNotes(String mentalRatingNotes) {
        this.mentalRatingNotes = mentalRatingNotes;
    }

    public String getPhysicalRatingNotes() {
        return physicalRatingNotes;
    }

    public void setPhysicalRatingNotes(String physicalRatingNotes) {
        this.physicalRatingNotes = physicalRatingNotes;
    }

    public String getTriumphs() {
        return triumphs;
    }

    public void setTriumphs(String triumphs) {
        this.triumphs = triumphs;
    }

    public String getSetbacks() {
        return setbacks;
    }

    public void setSetbacks(String setbacks) {
        this.setbacks = setbacks;
    }
}
