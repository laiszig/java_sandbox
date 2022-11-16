package ExampleTwo.looselyCoupled.notify;

import ExampleTwo.looselyCoupled.entity.Client_l;

public interface Notifier{

    void notifyMethod(Client_l client, String message);
}
