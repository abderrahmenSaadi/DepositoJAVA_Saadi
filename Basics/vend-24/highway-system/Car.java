public class Car extends Vehicle {
    private int seats;

    public Car(String licensePlate, double speed, int axles, int seats) {
        super(licensePlate, speed, axles);
        setSeats(seats);
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats <= 0) {
            throw new IllegalArgumentException("Seats must be > 0");
        }
        this.seats = seats;
    }

    @Override
    public double calculateToll() {
        return 2.0 + (getAxles() * 0.5);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Type: Car | Seats: " + seats);
    }
}