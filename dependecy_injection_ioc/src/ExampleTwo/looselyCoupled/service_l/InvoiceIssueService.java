package ExampleTwo.looselyCoupled.service_l;

import ExampleTwo.looselyCoupled.entity.Client_l;
import ExampleTwo.looselyCoupled.entity.Product_l;
import ExampleTwo.looselyCoupled.notify.Notifier;
import ExampleTwo.looselyCoupled.notify.SMSNotifier_l;

public class InvoiceIssueService {

    private Notifier notifier;

    public InvoiceIssueService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void issue(Client_l client, Product_l product){
        this.notifier.notifyMethod(client, "Product Invoice " + product.getName()
        + " was issued!");
    }
}
