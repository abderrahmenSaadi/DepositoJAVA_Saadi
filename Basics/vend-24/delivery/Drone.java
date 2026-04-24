import java.util.Random;

class Drone extends DeliveryVehicle implements Trackable {

    public Drone(String licensePlate, float maxLoad) {
        super(licensePlate, maxLoad);
    }

    @Override
    public void deliverPackage(String destination, float weight, String priority) {
        if (destination == null || destination.trim().isEmpty()) {
            System.out.println("Invalid destination!");
            return;
        }

        if (weight <= 0) {
            System.out.println("Invalid weight!");
            return;
        }

        if (weight > maxLoad) {
            System.out.println("ERROR: Package too heavy for drone!");
            return;
        }

        System.out.println("Drone [" + licensePlate + "] flying to " + destination + " (" + priority + ")");
        simulateOutcome();
    }

    @Override
    public void trackDelivery(String trackingCode) {
        System.out.println("Drone tracking [" + trackingCode + "]: Live GPS 📡");
    }

    private void simulateOutcome() {
        Random rand = new Random();
        int result = rand.nextInt(3);

        switch (result) {
            case 0 -> System.out.println("✔ Delivery completed successfully!");
            case 1 -> System.out.println("⚠ Weather delay.");
            case 2 -> System.out.println("❌ Battery issue. Returning to base.");
        }
    }
}