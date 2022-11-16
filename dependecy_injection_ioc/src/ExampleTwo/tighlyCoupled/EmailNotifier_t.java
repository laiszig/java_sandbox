package ExampleTwo.tighlyCoupled;

public class EmailNotifier_t {

    public void notifyMail(Client_t clientT, String message){
        System.out.printf("Notifying %s through email %s: %s \n",
                clientT.getName(), clientT.getEmail(), message);
    }
}
