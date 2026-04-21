

public class Main {
    public static void main(String[] args) {

        // ---- WORKSHOP PART ----
        Workshop workshop = new Workshop();

        try {
            Car car1 = new Car("AB123CD", "Fiat Panda");
            Car car2 = new Car("EF456GH", "Volkswagen Golf");

            workshop.addCar(car1);
            workshop.addCar(car2);

            // Edge case: duplicate
            workshop.addCar(new Car("AB123CD", "Different Model"));

            // Edge case: null
            workshop.addCar(null);

            workshop.printCars();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }



    }
}