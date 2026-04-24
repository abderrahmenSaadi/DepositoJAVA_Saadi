public abstract class Vehicle {
    private String licensePlate;
    private double speed;
    private int axles;

    public Vehicle(String licensePlate, double speed, int axles) {
        setLicensePlate(licensePlate);
        setSpeed(speed);
        setAxles(axles);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate == null || licensePlate.isEmpty()) {
            throw new IllegalArgumentException("Invalid license plate");
        }
        this.licensePlate = licensePlate;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.speed = speed;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        if (axles <= 0) {
            throw new IllegalArgumentException("Axles must be > 0");
        }
        this.axles = axles;
    }

    // Abstract method
    public abstract double calculateToll();

    public void printInfo() {
        System.out.println("Plate: " + licensePlate +
                " | Speed: " + speed +
                " | Axles: " + axles);
    }
}