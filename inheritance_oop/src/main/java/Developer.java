public class Developer extends Employee{

    // Constant variable, doesn't change
    private static final int MULTIPLIER = 1;

    // Overridden method using a different implementation
    @Override
    public void work() {
        System.out.println(this.getName() + " is coding...");
    }

    // Overridden method using a different implementation
    @Override
    public void getPaid() {
        System.out.println(this.getName() + " salary is " + this.getTotalCompensation(MULTIPLIER));
    }

    // Helper method to calculate compensation
    public double getTotalCompensation(int bonusMultiplier) {
        return this.getSalary() + (this.getSalary() * bonusMultiplier);
    }
}
