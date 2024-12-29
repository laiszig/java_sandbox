package com.laiszig.polyoop.employee;

public class SalariedEmployee extends Employee {

    private double salary;
    private final double discount;

    public SalariedEmployee(double salary) {
        this.salary = salary;
        this.discount = calculateDiscount(salary);
    }

    public double getSalary() {
        return salary;
    }

    public double getDiscount() {
        return discount;
    }

    private double calculateDiscount(double salary) {
        double result = 0;

        if(salary <= 1500) {
            result = 7.5;
        } if (salary <= 2500) {
            result = 9;
        } if (salary > 2500) {
            result = 12;
        }
        return result;
    }

    // Implementation of method pay for salaried employees
    @Override
    public double pay() {
        double x = this.discount * this.salary / 100;
        return this.salary - x;
    }

}
