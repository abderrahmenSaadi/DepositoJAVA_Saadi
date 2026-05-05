import java.util.Scanner;

public class FactorySystem {

    public static void main(String[] args) {

        Factory factory = Factory.getInstance();
        ConsoleView view = new ConsoleView(factory);
        factory.addObserver(view);

        VehicleController controller = new VehicleController();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== FACTORY MENU ===");
            System.out.println("1. Create Car");
            System.out.println("2. Create Motorcycle");
            System.out.println("3. Add Navigation");
            System.out.println("4. Add Sport Paint");
            System.out.println("5. Show Vehicles");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    controller.createCar();
                    break;

                case 2:
                    controller.createMotorcycle();
                    break;

                case 3:
                    System.out.print("Vehicle index: ");
                    controller.addNavigation(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Vehicle index: ");
                    controller.addSportPaint(sc.nextInt());
                    break;

                case 5:
                    view.displayVehicles();
                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}
