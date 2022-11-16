package ExampleTwo.tighlyCoupled;

import ExampleTwo.tighlyCoupled.service_t.ActivateClientService_t;

public class StudentMain_t {

    public static void main(String[] args) {

        Client_t john = new Client_t("John", "john@xyz.com", "32354353");
        Client_t mary = new Client_t("Mary", "mary@xyz.com", "57964854");

        ActivateClientService_t clientService = new ActivateClientService_t();
        clientService.activate(john);
        clientService.activate(mary);
    }
}
