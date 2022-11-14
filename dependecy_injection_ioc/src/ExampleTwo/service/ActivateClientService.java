package ExampleTwo.service;

import ExampleTwo.Client;
import ExampleTwo.EmailNotifier;

public class ActivateClientService {

    public void activate(Client client) {
        client.activate();

        EmailNotifier notifier = new EmailNotifier();
        notifier.notifyMail(client, "Your registration in our system is active!");
    }
}
