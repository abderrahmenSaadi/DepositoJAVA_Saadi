abstract class DeliveryVehicle {
    protected String licensePlate;
    protected float maxLoad;

    public DeliveryVehicle(String licensePlate, float maxLoad) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid license plate!");
        }
        if (maxLoad <= 0) {
            throw new IllegalArgumentException("Max load must be > 0!");
        }

        this.licensePlate = licensePlate;
        this.maxLoad = maxLoad;
    }

    public abstract void deliverPackage(String destination, float weight, String priority);

    public void printInfo() {
        System.out.println("Plate: " + licensePlate + " | Max load: " + maxLoad + " kg");
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}