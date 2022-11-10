package cars;

import cars.Car;
import cars.Owner;

public class CarMain {

    public static void main(String[] args) {
        Car car; //declare variable
        car = new Car(); //instantiate car

        Car car2 = new Car(); //declar and instantiate car

        car.manufacturer = "Honda"; //public access modifier
        car.setColor("Blue");
        car.setManufacturer("Volkswagen");
        car.setModel("Gol");
        car.setYear(1998);

        Owner owner = new Owner();
        owner.setName("John Stuart");
        owner.setAge(32);
        owner.setAddress("32 Maryland St.");
        owner.setState("CA");
        owner.setCity("Los Angeles");

        car.setOwner(owner);

//        System.out.println(car);
        System.out.println(car.getOwner());
//        System.out.println(owner.getName());
//        System.out.println(car2);
    }
}