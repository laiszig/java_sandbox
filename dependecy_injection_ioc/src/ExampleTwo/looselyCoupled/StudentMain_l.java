package ExampleTwo.looselyCoupled;

import ExampleTwo.looselyCoupled.entity.Client_l;
import ExampleTwo.looselyCoupled.notify.EmailNotifier_l;
import ExampleTwo.looselyCoupled.notify.Notifier;
import ExampleTwo.looselyCoupled.notify.SMSNotifier_l;
import ExampleTwo.looselyCoupled.service_l.ActivateClientService_l;

public class StudentMain_l {

    public static void main(String[] args) {

        Client_l john = new Client_l("John", "john@xyz.com", "32354353");
        Client_l mary = new Client_l("Mary", "mary@xyz.com", "57964854");

        Notifier notifier = new SMSNotifier_l();

        ActivateClientService_l clientService = new ActivateClientService_l(notifier);
        clientService.activate(john);
        clientService.activate(mary);
    }
}
