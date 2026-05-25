package com.mmmyesgames.UFCAPI.entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table(name="fight")
public class Fight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int redFighter;
    private int blueFighter;
    private int winner;
    private int rounds;
    private Duration time;
    private LocalDate date;
    private String weightClass;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRedFighter() {
        return redFighter;
    }

    public void setRedFighter(int redFighter) {
        this.redFighter = redFighter;
    }

    public int getBlueFighter() {
        return blueFighter;
    }

    public void setBlueFighter(int blueFighter) {
        this.blueFighter = blueFighter;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }


}
