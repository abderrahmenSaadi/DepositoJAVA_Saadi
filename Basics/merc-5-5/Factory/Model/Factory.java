import java.util.*;

public class Factory implements Subject {

    private static Factory instance;
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Factory() {}

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public void produceVehicle(Vehicle v) {
        vehicles.add(v);
        notifyObservers();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // Observer methods
    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}