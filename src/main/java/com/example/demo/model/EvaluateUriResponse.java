package com.example.demo.model;

import java.util.List;

public class EvaluateUriResponse {
    // Example fields, replace with actual fields from the API response
    private List<Score> scores;

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public static class Score {
        private ThreatType threatType;
        private ConfidenceLevel confidenceLevel;

        public ThreatType getThreatType() {
            return threatType;
        }

        public void setThreatType(ThreatType threatType) {
            this.threatType = threatType;
        }

        public ConfidenceLevel getConfidenceLevel() {
            return confidenceLevel;
        }

        public void setConfidenceLevel(ConfidenceLevel confidenceLevel) {
            this.confidenceLevel = confidenceLevel;
        }
    }
    public enum ThreatType {
        THREAT_TYPE_UNSPECIFIED, // and other threat types as per API
        MALWARE,
        SOCIAL_ENGINEERING,
        // ... other threat types
    }

    public enum ConfidenceLevel {
        CONFIDENCE_LEVEL_UNSPECIFIED, // and other confidence levels as per API
        SAFE,
        LOW,
        MEDIUM,
        HIGH,
        HIGHER,
        VERY_HIGH,
        EXTREMELY_HIGH
        // ... other confidence levels
    }
}