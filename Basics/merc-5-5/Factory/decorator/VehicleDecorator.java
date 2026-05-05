public abstract class VehicleDecorator extends Vehicle {
    protected Vehicle vehicle;
    // Constructor to initialize the decorator with the vehicle it decorates
    public VehicleDecorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    // Abstract method to be implemented by concrete decorators to modify the description

    public abstract String getDescription();
}