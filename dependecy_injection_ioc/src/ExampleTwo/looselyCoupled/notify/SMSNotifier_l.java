package ExampleTwo.looselyCoupled.notify;

import ExampleTwo.looselyCoupled.entity.Client_l;

public class SMSNotifier_l implements Notifier {

    @Override
    public void notifyMethod(Client_l client, String message) {
        System.out.printf("Notifying %s by SMS through phone %s: %s\n",
                client.getName(), client.getPhone(), message);
    }
}
