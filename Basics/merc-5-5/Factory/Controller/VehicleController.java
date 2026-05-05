public class VehicleController {

    private Factory factory;
    // Constructor to initialize the controller with the factory instance

    public VehicleController() {
        factory = Factory.getInstance();
    }

    public void createCar() {
        factory.produceVehicle(new Car());
    }

    public void createMotorcycle() {
        factory.produceVehicle(new Motorcycle());
    }

    public void addNavigation(int index) {
        Vehicle v = factory.getVehicles().get(index);
        factory.getVehicles().set(index, new NavigationDecorator(v));
    }

    public void addSportPaint(int index) {
        Vehicle v = factory.getVehicles().get(index);
        factory.getVehicles().set(index, new SportPaintDecorator(v));
    }
}