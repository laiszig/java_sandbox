package com.laiszig.functioncomposition.candidate;

public enum StudyLevel {

    ASSOCIATE("Associate Degree"),
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    DOCTOR("Doctoral degree");

    private String level;

    StudyLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
