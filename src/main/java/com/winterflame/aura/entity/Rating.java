package com.winterflame.aura.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    public int ratingId;

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

    public int getRatingId() {
        return this.ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRatingOrder() {
        return this.ratingOrder;
    }

    public void setRatingOrder(int ratingOrder) {
        this.ratingOrder = ratingOrder;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", overview='" + overview + '\'' +
                ", ratingOrder='" + ratingOrder + '\'' +
                '}';
    }
}
