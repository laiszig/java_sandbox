package com.laiszig.polyoop;

import com.laiszig.polyoop.employee.Employee;
import com.laiszig.polyoop.employee.Payable;

public class Report {

    // Method capable of printing employees of different contract types
    public void print(Payable payable) {

        // Use of instanceof binary operator to test the type of payable.Employee before calling its pay method
        if (payable instanceof Employee) {
            Employee employee = (Employee) payable;
            double result = payable.pay();
            System.out.println(
                    "payable.Employee: " + employee.getName() + '\n' +
                    "Job Title: " + employee.getJobTitle().getTitle() + '\n' +
                    "Total compensations is " + result);
        } else {
            System.out.println("Total compensations is " + payable.pay());
        }
    }

}
