package com.winterflame.aura.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "overview")
    public String overview;

    @Column(name = "rating_order")
    public int ratingOrder;

    public Rating() {
    }

    public Rating(String overview, int ratingOrder) {
        this.overview = overview;
        this.ratingOrder = ratingOrder;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRankOrder() {
        return this.ratingOrder;
    }

    public void setRankOrder(int rankOrder) {
        this.ratingOrder = rankOrder;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", overview='" + overview + '\'' +
                ", ratingOrder='" + ratingOrder + '\'' +
                '}';
    }
}
