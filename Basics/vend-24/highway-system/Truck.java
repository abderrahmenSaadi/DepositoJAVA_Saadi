public class Truck extends Vehicle {
    private double weight;

    public Truck(String licensePlate, double speed, int axles, double weight) {
        super(licensePlate, speed, axles);
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be > 0");
        }
        this.weight = weight;
    }

    @Override
    public double calculateToll() {
        return 5.0 + (getAxles() * 1.5) + (weight * 0.01);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Truck | Weight: " + weight + " tons");
    }
}