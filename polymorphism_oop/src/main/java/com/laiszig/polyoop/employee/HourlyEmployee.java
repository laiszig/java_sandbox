package com.laiszig.polyoop.employee;

// Subclass of payable.Employee
public class HourlyEmployee extends Employee{

    private final double rate;
    private final double hoursWorked;

    public HourlyEmployee(double rate, double hoursWorked) {
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public double getRate() {
        return rate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // Implementation of method pay for hourly employees
    @Override
    public double pay() {
        return this.getRate() * this.getHoursWorked();
    }
}
