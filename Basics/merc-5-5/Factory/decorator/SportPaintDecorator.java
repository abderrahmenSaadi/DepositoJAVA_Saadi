public class SportPaintDecorator extends VehicleDecorator {
    // Constructor to initialize the decorator with the vehicle it decorates
    public SportPaintDecorator(Vehicle vehicle) {
        super(vehicle);
    }
    // Override the getDescription method to add sport paint details
    @Override
    public String getDescription() {
        return vehicle.getDescription() + " with sport paint";
    }
}