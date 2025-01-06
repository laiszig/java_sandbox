package com.laiszig.functioncomposition.candidate;

import java.util.List;

public class Candidate {

    private String name;
    private int yearsOfExperience;
    private String level;
    private List<ProgrammingLanguages> programmingLanguages;
    private List<DataBases> dbs;
    private EnglishLevel englishLevel;
    private StudyLevel studyLevel;
    private List<Frameworks> frameworks;
    private boolean mobileExperience;
    private double salaryExpectation;

    public Candidate(String name, int yearsOfExperience,
                     String level, List<ProgrammingLanguages> programmingLanguages,
                     List<DataBases> dbs, EnglishLevel englishLevel,
                     StudyLevel studyLevel, List<Frameworks> frameworks,
                     boolean mobileExperience, double salaryExpectation) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.level = level;
        this.programmingLanguages = programmingLanguages;
        this.dbs = dbs;
        this.englishLevel = englishLevel;
        this.studyLevel = studyLevel;
        this.frameworks = frameworks;
        this.mobileExperience = mobileExperience;
        this.salaryExpectation = salaryExpectation;
    }

    public Candidate() {
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getLevel() {
        return level;
    }

    public List<ProgrammingLanguages> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public List<DataBases> getDbs() {
        return dbs;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public StudyLevel getStudyLevel() {
        return studyLevel;
    }

    public List<Frameworks> getFrameworks() {
        return frameworks;
    }

    public boolean hasMobileExperience() {
        return mobileExperience;
    }

    public double getSalaryExpectation() {
        return salaryExpectation;
    }
}
