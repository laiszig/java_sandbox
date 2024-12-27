public class Main {

    public static void main(String[] args) {

        HourlyEmployee employee1 = new HourlyEmployee(15, 160);
        employee1.setName("John Smith");
        employee1.setJobTitle(JobTitle.HR_ASSISTANT);

        SalariedEmployee employee2 = new SalariedEmployee(3500);
        employee2.setName("Mary Williams");
        employee2.setJobTitle(JobTitle.SOFTWARE_DEVELOPER);

        Employee employee = new Employee();
        employee.setName("Jim Peterson");
        employee.setJobTitle(JobTitle.MANAGER);

        Report report = new Report();

        report.print(employee1);
        report.print(employee2);
        report.print(employee);

    }
}
