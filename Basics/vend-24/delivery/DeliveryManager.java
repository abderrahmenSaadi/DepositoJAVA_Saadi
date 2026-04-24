import java.util.*;

public class DeliveryManager {

    private static boolean plateExists(ArrayList<DeliveryVehicle> list, String plate) {
        for (DeliveryVehicle v : list) {
            if (v.getLicensePlate().equalsIgnoreCase(plate)) {
                return true;
            }
        }
        return false;
    }

    private static void showVehicles(ArrayList<DeliveryVehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        System.out.println("\n--- VEHICLES ---");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.print((i + 1) + ". ");
            vehicles.get(i).printInfo();
        }
    }

    private static int selectVehicle(Scanner sc, ArrayList<DeliveryVehicle> vehicles) {
        showVehicles(vehicles);

        if (vehicles.isEmpty()) return -1;

        int choice = -1;

        while (true) {
            try {
                System.out.print("Select vehicle (1-" + vehicles.size() + "): ");
                choice = Integer.parseInt(sc.nextLine());

                if (choice >= 1 && choice <= vehicles.size()) {
                    return choice - 1; // convert to 0-based
                } else {
                    System.out.println("Invalid selection!");
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number!");
            }
        }
    }

    private static void addVan(Scanner sc, ArrayList<DeliveryVehicle> vehicles) {
        System.out.print("License plate: ");
        String plate = sc.nextLine();

        if (plateExists(vehicles, plate)) {
            System.out.println("Plate already exists!");
            return;
        }

        try {
            System.out.print("Max load: ");
            float load = Float.parseFloat(sc.nextLine());

            vehicles.add(new Van(plate, load));
            System.out.println("Van added!");

        } catch (Exception e) {
            System.out.println("Invalid load!");
        }
    }

    private static void addDrone(Scanner sc, ArrayList<DeliveryVehicle> vehicles) {
        System.out.print("License plate: ");
        String plate = sc.nextLine();

        if (plateExists(vehicles, plate)) {
            System.out.println("Plate already exists!");
            return;
        }

        try {
            System.out.print("Max load: ");
            float load = Float.parseFloat(sc.nextLine());

            vehicles.add(new Drone(plate, load));
            System.out.println("Drone added!");

        } catch (Exception e) {
            System.out.println("Invalid load!");
        }
    }

private static void deliver(Scanner sc, ArrayList<DeliveryVehicle> vehicles, ArrayList<PackageDelivery> deliveries) {

    int index = selectVehicle(sc, vehicles);
    if (index == -1) return;

    System.out.print("Destination: ");
    String dest = sc.nextLine();

    float weight;
    try {
        System.out.print("Weight: ");
        weight = Float.parseFloat(sc.nextLine());
    } catch (Exception e) {
        System.out.println("Invalid weight!");
        return;
    }

    System.out.print("Priority (NORMAL / EXPRESS): ");
    String priority = sc.nextLine().toUpperCase();

    if (!priority.equals("EXPRESS")) {
        priority = "NORMAL";
    }

    DeliveryVehicle vehicle = vehicles.get(index);

    // 🔹 Create package FIRST
    PackageDelivery pkg = new PackageDelivery(dest, vehicle);

    // 🔹 Try delivery
    vehicle.deliverPackage(dest, weight, priority);

    // 🔹 Update status logically
    pkg.updateStatus("IN TRANSIT");

    deliveries.add(pkg);

    System.out.println("📦 Package created!");
    System.out.println("Your tracking code is: " + pkg.getTrackingCode());
}

   private static void track(Scanner sc, ArrayList<PackageDelivery> deliveries) {

    if (deliveries.isEmpty()) {
        System.out.println("No deliveries found.");
        return;
    }

    System.out.print("Enter tracking code: ");
    String code = sc.nextLine().toUpperCase();

    for (PackageDelivery pkg : deliveries) {
        if (pkg.getTrackingCode().equals(code)) {
            pkg.printTracking();
            return;
        }
    }

    System.out.println("Tracking code not found!");
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<DeliveryVehicle> vehicles = new ArrayList<DeliveryVehicle>();
        ArrayList<PackageDelivery> deliveries = new ArrayList<>();

        // 🔹 Preloaded
        vehicles.add(new Van("VAN123", 1000));
        vehicles.add(new Drone("DRN001", 5));
        vehicles.add(new Van("VAN999", 800));

        int choice = -1;

        do {
            System.out.println("\n==== DELIVERY SYSTEM ====");
            System.out.println("1. Add Van");
            System.out.println("2. Add Drone");
            System.out.println("3. Deliver Package");
            System.out.println("4. Track Delivery");
            System.out.println("5. Show Vehicles");
            System.out.println("0. Exit");

            System.out.print("Choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {

                case 1:
                    addVan(sc, vehicles);
                    break;

                case 2:
                    addDrone(sc, vehicles);
                    break;

                case 3:
                     deliver(sc, vehicles, deliveries);
                     break;

                case 4:
                    track(sc, deliveries);
                    break;

                case 5:
                    showVehicles(vehicles);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}