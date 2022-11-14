package ExampleTwo;

public class EmailNotifier {

    public void notifyMail(Client client, String message){
        System.out.printf("Notifying %s through email %s: %s \n",
                client.getName(), client.getEmail(), message);
    }
}
