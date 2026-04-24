import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Workshop workshop = new Workshop();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Workshop System ===");

        while (true) {
            System.out.println("\n1. Add Car");
            System.out.println("2. Show Cars");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter license plate: ");
                        String plate = scanner.nextLine().trim();

                        System.out.print("Enter model: ");
                        String model = scanner.nextLine().trim();

                        Car car = new Car(plate, model);
                        boolean added = workshop.addCar(car);

                        if (added) {
                        System.out.println("Car added successfully.");
                        } else {
                        System.out.println("Failed to add car.");       
                        }   
                        break;

                    case 2:
                        workshop.printCars();
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}