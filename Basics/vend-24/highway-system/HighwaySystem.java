import java.util.ArrayList;

public class HighwaySystem {
    private ArrayList<Vehicle> vehicles;

    public HighwaySystem() {
        vehicles = new ArrayList<>();
    }

    // جلوگیری از تکرار پلاک (duplicate prevention)
    public boolean addVehicle(Vehicle v) {
        if (findVehicleByPlate(v.getLicensePlate()) != null) {
            System.out.println("❌ Vehicle with this plate already exists!");
            return false;
        }

        vehicles.add(v);
        System.out.println("✅ Vehicle added successfully!");
        printVehicleArt(v);
        return true;
    }

    // Search by plate
    public Vehicle findVehicleByPlate(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getLicensePlate().equalsIgnoreCase(plate)) {
                return v;
            }
        }
        return null;
    }

    public void showVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the system.");
            return;
        }

        for (Vehicle v : vehicles) {
            v.printInfo();
            printVehicleArt(v);
            System.out.println("----------------------");
        }
    }

    public void calculateTolls() {
        for (Vehicle v : vehicles) {
            System.out.println("Plate: " + v.getLicensePlate()
                    + " | Toll: €" + v.calculateToll());
        }
    }

    // 🏁 RACE FEATURE
    public void raceVehicles(String plate1, String plate2) {
        Vehicle v1 = findVehicleByPlate(plate1);
        Vehicle v2 = findVehicleByPlate(plate2);

        if (v1 == null || v2 == null) {
            System.out.println("❌ One or both vehicles not found!");
            return;
        }

        System.out.println("\n🏁 RACE START!");
        printVehicleArt(v1);
        System.out.println("VS");
        printVehicleArt(v2);

        if (v1.getSpeed() > v2.getSpeed()) {
            System.out.println("🏆 Winner: " + v1.getLicensePlate());
        } else if (v2.getSpeed() > v1.getSpeed()) {
            System.out.println("🏆 Winner: " + v2.getLicensePlate());
        } else {
            System.out.println("🤝 It's a tie!");
        }
    }

    // 🎨 ASCII ART (fun addition)
    private void printVehicleArt(Vehicle v) {
        if (v instanceof Car) {
            System.out.println("   ____");
            System.out.println(" _/[] []\\_");
            System.out.println("(________)");
        } else if (v instanceof Truck) {
            System.out.println(" _________");
            System.out.println("|         |____");
            System.out.println("| TRUCK        \\__");
            System.out.println("O-------------O");
        } else if (v instanceof Motorcycle) {
            System.out.println("   __o");
            System.out.println(" _ \\<,_");
            System.out.println("(_)/ (_)");
        }
    }
}