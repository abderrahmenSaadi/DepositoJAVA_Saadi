public class Car {
    private String licensePlate;
    private String model;

    public Car(String licensePlate, String model) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty.");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }

        this.licensePlate = licensePlate.trim();
        this.model = model.trim();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "License Plate: " + licensePlate + ", Model: " + model;
    }

    // Optional: prevents duplicate cars based on license plate
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;

        Car other = (Car) obj;
        return this.licensePlate.equalsIgnoreCase(other.licensePlate);
    }

    @Override
    public int hashCode() {
        return licensePlate.toLowerCase().hashCode();
    }
}