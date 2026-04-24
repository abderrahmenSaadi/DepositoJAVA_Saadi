public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String licensePlate, double speed, int axles, int engineCapacity) {
        super(licensePlate, speed, axles);
        setEngineCapacity(engineCapacity);
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Engine capacity must be > 0");
        }
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateToll() {
        return 1.0 + (engineCapacity / 1000.0);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Motorcycle | Engine: " + engineCapacity + "cc");
    }
}