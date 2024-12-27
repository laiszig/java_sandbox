public class Report {

    // Method capable of printing employees of different contract types
    public void print(Employee employee) {
        // Use of instanceof binary operator to test the type of Employee before calling its pay method
        if (employee instanceof Payable payable) {
            double result = payable.pay();
            System.out.println(
                    "Employee: " + employee.getName() + '\n' +
                    "Job Title: " + employee.getJobTitle().getTitle() + '\n' +
                    "Total compensations is " + result);
        } else {
            System.out.println(
                    "Employee: " + employee.getName() + '\n' +
                    "Job Title: " + employee.getJobTitle().getTitle() + '\n' +
                            "Compensation not informed");
        }
    }


}
