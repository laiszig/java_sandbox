package ExampleTwo.looselyCoupled.service_l;

import ExampleTwo.looselyCoupled.entity.Client_l;
import ExampleTwo.looselyCoupled.notify.Notifier;

public class ActivateClientService_l {

    private Notifier notifier;

    public ActivateClientService_l(Notifier notifier) {
        this.notifier = notifier;
    }

    public void activate(Client_l clientL) {
        clientL.activate();

        this.notifier.notifyMethod(clientL, "Your registration in our system is active!");
    }
}
