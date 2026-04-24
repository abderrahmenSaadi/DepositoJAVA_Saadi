import java.util.Random;

class Van extends DeliveryVehicle implements Trackable {

    public Van(String licensePlate, float maxLoad) {
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
            System.out.println("ERROR: Package exceeds van capacity!");
            return;
        }

        System.out.println("Van [" + licensePlate + "] delivering via ROAD to " + destination + " (" + priority + ")");
        simulateOutcome();
    }

    @Override
    public void trackDelivery(String trackingCode) {
        System.out.println("Van tracking [" + trackingCode + "]: On the road 🚚");
    }

    private void simulateOutcome() {
        Random rand = new Random();
        int result = rand.nextInt(3);

        switch (result) {
            case 0 -> System.out.println("✔ Delivery completed successfully!");
            case 1 -> System.out.println("⚠ Delay due to traffic.");
            case 2 -> System.out.println("❌ Delivery failed. Retry scheduled.");
        }
    }
}