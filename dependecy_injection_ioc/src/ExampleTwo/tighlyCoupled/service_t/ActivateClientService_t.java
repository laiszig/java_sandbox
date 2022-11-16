package ExampleTwo.tighlyCoupled.service_t;

import ExampleTwo.tighlyCoupled.Client_t;
import ExampleTwo.tighlyCoupled.EmailNotifier_t;

public class ActivateClientService_t {

    public void activate(Client_t clientT) {
        clientT.activate();

        EmailNotifier_t notifier = new EmailNotifier_t();
        notifier.notifyMail(clientT, "Your registration in our system is active!");
    }
}
