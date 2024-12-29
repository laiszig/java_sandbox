package com.laiszig.polyoop.employee;

// Base class
public abstract class Employee implements Payable {

    private String name;
    private JobTitle jobTitle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }
}
