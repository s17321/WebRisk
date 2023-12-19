package com.example.demo.model;

import java.util.List;

public class EvaluateUriResponse {
    private List<Score> scores;

    // Konstruktory, gettery i settery

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}