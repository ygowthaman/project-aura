package com.winterflame.aura.entity;

import java.time.LocalDateTime;

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
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "panoramic_id", nullable = false)
    private Panorama panorama;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Vibe() {
    }

    public Vibe(LocalDateTime date, Panorama panorama, User user) {
        this.date = date;
        this.panorama = panorama;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Panorama getPanorama() {
        return panorama;
    }

    public void setPanorama(Panorama panorama) {
        this.panorama = panorama;
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
                ", panoramaId=" + (panorama != null ? panorama.getId() : null) +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }

}
