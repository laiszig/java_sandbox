import java.time.Year;

// Base class
public class Employee {

    // static variable to count number of employees created, only used in this class
    private static int employeeCount = 0;

    private String name;
    private int salary;
    private int startDate;

    public Employee() {
        employeeCount ++;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void displayEmployeCount() {
        System.out.println("Total Employees: " + employeeCount);
    }

    //3 methods

    public void getYearsOfService() {
        int currentYear = Year.now().getValue();
        System.out.println(this.getName() + " years of service: " + (currentYear - this.getStartDate()));
    }

    public void work() {
        System.out.println(this.getName() + " is working.");
    }

    public void getPaid() {
        System.out.println(this.getName() + " salary is " + this.getSalary());
    }

}
