package ExampleTwo;

import ExampleTwo.service.ActivateClientService;

public class StudentMain {

    public static void main(String[] args) {

        Client john = new Client("John", "john@xyz.com", "32354353");
        Client mary = new Client("Mary", "mary@xyz.com", "57964854");

        ActivateClientService clientService = new ActivateClientService();
        clientService.activate(john);
        clientService.activate(mary);
    }
}
