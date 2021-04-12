import cars.Car;
import cars.ShowRoom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    ShowRoom showRoom = new ShowRoom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    void showMenu() {
        String userInPut = "";

        do {
            System.out.println("Welcome to showroom, please choose activity:");
            System.out.println();
            System.out.println("1. Add car");
            System.out.println("2. View all cars");
            System.out.println("3. View single car");
            System.out.println("4. Remove car");
            System.out.println("5. Update car");
            System.out.println("\nEnter Quit to End Programm\n");

            System.out.print("Enter your choice:");

            userInPut = scanner.nextLine();
            switch (userInPut) {
                case "quit":
                    System.out.println("Exiting app");
                    break;
                case "1":
                    addCar();
                    break;
                case "2":
                    viewAllCars();
                    break;
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    deleteCar();
                    break;
                case "5":
                    updateCar();
                    break;
                default:
                    break;
            }
        } while (!userInPut.equalsIgnoreCase("quit"));
        return;
    }
    void addCar() {
        System.out.println("\n Add car");

        Car car = new Car();
        System.out.println("Enter Name:");
        car.name = scanner.nextLine();

        System.out.println("Enter Manufacturer:");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type:");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();

        String message = showRoom.addCar(car);
        System.out.println(message);

        System.out.println("\n Press enter to continue\n");
        scanner.nextLine();
    }
    void viewAllCars() {
        ArrayList<Car> allCars = showRoom.getAllCars();
        System.out.println("\nAll avaliable cars\n");
        System.out.println("ID\t Car name\t  Manufaturer\t Car Type");

        int counter = 0;

        for (Car car : allCars) {
            System.out.println(counter + ". \t" + car.name + " \t" + car.manufacturer + " \t" + car.type);
            counter++;
        }

    }
    void viewSingleCar() {
        System.out.println("View Car\n");
        System.out.println("Enter Id");
        int carId = scanner.nextInt();
        Car car = showRoom.getSingleCar(carId);

        System.out.println("Car id: " + car.id);
        System.out.println("Car name: " + car.name);
        System.out.println("Car manufacturer: " + car.manufacturer);
        System.out.print("Car type: " + car.type);

    }
    void deleteCar(){
        System.out.println("Delete car\n" );
        System.out.println("Enter car ID" );

        int carId = scanner.nextInt();
        String message = showRoom.removeCar(carId);

        System.out.print(message);
    }
    void updateCar(){
        Car car = new Car();
        this.viewAllCars();
        System.out.println("Update Car");
        int carId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name for car");
        car.name = scanner.nextLine();
        System.out.println("Enter car type");
        car.type = scanner.nextLine();
        System.out.println("Enter car manufacturer");
        car.manufacturer = scanner.nextLine();

        String response = showRoom.updateCar(carId, car);
        System.out.println(response);
    }
}