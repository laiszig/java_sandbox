package ExampleTwo.looselyCoupled.notify;

import ExampleTwo.looselyCoupled.entity.Client_l;

public class EmailNotifier_l implements Notifier{

    @Override
    public void notifyMethod(Client_l clientL, String message){
        System.out.printf("Notifying %s through email %s: %s \n",
                clientL.getName(), clientL.getEmail(), message);
    }
}
