public class DevLead extends Developer {

    // Overloaded method with different parameters
    public void getPaid(int numberOfTeams) {
        System.out.println(this.getName() + " salary is " + this.getTotalCompensation(numberOfTeams));
    }

}
