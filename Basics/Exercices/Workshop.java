import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private List<Car> cars;

    public Workshop() {
        cars = new ArrayList<>();
    }

    public boolean addCar(Car car) {
        if (car == null) {
            System.out.println("Cannot add a null car.");
            return false;
        }

        if (cars.contains(car)) {
            System.out.println("Car with this license plate already exists.");
            return false;
        }

        cars.add(car);
        return true;
    }

    public void printCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars in the workshop.");
            return;
        }

        System.out.println("Cars in the workshop:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
