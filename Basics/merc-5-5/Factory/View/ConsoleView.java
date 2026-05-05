import java.util.List;

public class ConsoleView implements Observer {

    private Factory factory;

    public ConsoleView(Factory factory) {
        this.factory = factory;
    }

    public void update() {
        System.out.println("\n[VIEW UPDATED] New vehicle added!");
        displayVehicles();
    }

    public void displayVehicles() {
        List<Vehicle> list = factory.getVehicles();
        System.out.println("\n--- Vehicles Produced ---");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i).getDescription());
        }
    }
}