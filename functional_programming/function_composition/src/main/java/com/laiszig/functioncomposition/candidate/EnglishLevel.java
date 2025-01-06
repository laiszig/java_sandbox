package com.laiszig.functioncomposition.candidate;

public enum EnglishLevel {

    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced"),
    FLUENT("Fluent");

    private String level;

    EnglishLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
