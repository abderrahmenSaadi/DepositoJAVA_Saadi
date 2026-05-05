public class NavigationDecorator extends VehicleDecorator {
    // Constructor to initialize the decorator with the vehicle it decorates
    public NavigationDecorator(Vehicle vehicle) {
        super(vehicle);
    }
    // Override the getDescription method to add navigation details
    @Override
    public String getDescription() {
        return vehicle.getDescription() + " with navigation system";
    }
}