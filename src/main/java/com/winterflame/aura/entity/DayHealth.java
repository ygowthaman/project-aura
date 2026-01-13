package com.winterflame.aura.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "day_health")
public class DayHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="health_entry_id")
    public int healthEntryId;

    @OneToOne
    @JoinColumn(name="vibe_id")
    public Vibe vibe;

    @ManyToOne
    @JoinColumn(name="mental_rating_id")
    public Rating mentalRating;

    @ManyToOne
    @JoinColumn(name="physical_rating_id")
    public Rating physicalRating;

    @Column(name="mental_health_notes")
    public String mentalHealthNotes;

    @Column(name="physical_health_notes")
    public String physicalHealthNotes;

    @Column(name="wins")
    public String wins;

    @Column(name="setbacks")
    public String setbacks;

    public DayHealth() {
    }

    public DayHealth(Vibe vibe, Rating mentalRating, Rating physicalRating, String mentalHealthNotes, String physicalHealthNotes, String wins, String setbacks) {
        this.vibe = vibe;
        this.mentalRating = mentalRating;
        this.physicalRating = physicalRating;
        this.mentalHealthNotes = mentalHealthNotes;
        this.physicalHealthNotes = physicalHealthNotes;
        this.wins = wins;
        this.setbacks = setbacks;
    }

    public void setHealthEntryId(int healthEntryId) {
        this.healthEntryId = healthEntryId;
    }

    public void setVibe(Vibe vibe) {
        this.vibe = vibe;
    }

    public void setMentalRating(Rating mentalRating) {
        this.mentalRating = mentalRating;
    }

    public void setPhysicalRating(Rating physicalRating) {
        this.physicalRating = physicalRating;
    }

    public void setMentalHealthNotes(String mentalHealthNotes) {
        this.mentalHealthNotes = mentalHealthNotes;
    }

    public void setPhysicalHealthNotes(String physicalHealthNotes) {
        this.physicalHealthNotes = physicalHealthNotes;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public void setSetbacks(String setbacks) {
        this.setbacks = setbacks;
    }

    public int getHealthEntryId() {
        return healthEntryId;
    }

    public Vibe getVibe() {
        return vibe;
    }

    public Rating getMentalRating() {
        return mentalRating;
    }

    public Rating getPhysicalRating() {
        return physicalRating;
    }

    public String getMentalHealthNotes() {
        return mentalHealthNotes;
    }

    public String getPhysicalHealthNotes() {
        return physicalHealthNotes;
    }

    public String getWins() {
        return wins;
    }

    public String getSetbacks() {
        return setbacks;
    }

    @Override
    public String toString() {
        return "DayHealth{" +
                "healthEntryId=" + healthEntryId +
                ", vibe=" + vibe +
                ", mentalRating='" + mentalRating + '\'' +
                ", physicalRating='" + physicalRating + '\'' +
                ", mentalHealthNotes='" + mentalHealthNotes + '\'' +
                ", physicalHealthNotes='" + physicalHealthNotes + '\'' +
                ", wins='" + wins + '\'' +
                ", setbacks='" + setbacks + '\'' +
                '}';
    }
}
