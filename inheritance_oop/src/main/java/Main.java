public class Main {

    public static void main(String[] args) {

        /*
        Multilevel inheritance test class
        */

        // Employee 1 using base class
        Employee employee1 = new Employee();
        employee1.setName("John");
        employee1.setSalary(1000);
        employee1.setStartDate(2021);

        employee1.work();
        employee1.getPaid();
        employee1.getYearsOfService();

        // Employee 2 using intermediary class
        Developer employee2 = new Developer();
        employee2.setName("Mary");
        employee2.setSalary(2500);
        employee2.setStartDate(2019);

        employee2.work();
        employee2.getYearsOfService();
        employee2.getPaid();

        // Employee 3 using derived class
        DevLead employee3 = new DevLead();
        employee3.setName("Liv");
        employee3.setSalary(3000);
        employee3.setStartDate(2015);

        employee3.work();
        employee3.getYearsOfService();
        // Using overloaded method, by passing an argument
        employee3.getPaid(3);

        // Print employee count using static variable inside base class
        Employee.displayEmployeCount();
    }
}
