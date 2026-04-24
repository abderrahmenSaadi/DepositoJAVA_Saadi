import java.util.Scanner;

public class HighwayApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HighwaySystem system = new HighwaySystem();

        int choice;

        do {
            System.out.println("\n=== 🚗 HIGHWAY SYSTEM MENU ===");
            System.out.println("1. Add Car");
            System.out.println("2. Add Truck");
            System.out.println("3. Add Motorcycle");
            System.out.println("4. Show Vehicles");
            System.out.println("5. Calculate Tolls");
            System.out.println("6. Race Vehicles 🏁");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Plate: ");
                        String cPlate = scanner.next();
                        System.out.print("Speed: ");
                        double cSpeed = scanner.nextDouble();
                        System.out.print("Axles: ");
                        int cAxles = scanner.nextInt();
                        System.out.print("Seats: ");
                        int seats = scanner.nextInt();

                        system.addVehicle(new Car(cPlate, cSpeed, cAxles, seats));
                        break;

                    case 2:
                        System.out.print("Plate: ");
                        String tPlate = scanner.next();
                        System.out.print("Speed: ");
                        double tSpeed = scanner.nextDouble();
                        System.out.print("Axles: ");
                        int tAxles = scanner.nextInt();
                        System.out.print("Weight: ");
                        double weight = scanner.nextDouble();

                        system.addVehicle(new Truck(tPlate, tSpeed, tAxles, weight));
                        break;

                    case 3:
                        System.out.print("Plate: ");
                        String mPlate = scanner.next();
                        System.out.print("Speed: ");
                        double mSpeed = scanner.nextDouble();
                        System.out.print("Axles: ");
                        int mAxles = scanner.nextInt();
                        System.out.print("Engine (cc): ");
                        int engine = scanner.nextInt();

                        system.addVehicle(new Motorcycle(mPlate, mSpeed, mAxles, engine));
                        break;

                    case 4:
                        system.showVehicles();
                        break;

                    case 5:
                        system.calculateTolls();
                        break;

                    case 6:
                        System.out.print("Enter first plate: ");
                        String p1 = scanner.next();
                        System.out.print("Enter second plate: ");
                        String p2 = scanner.next();

                        system.raceVehicles(p1, p2);
                        break;

                    case 0:
                        System.out.println("👋 Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }
}