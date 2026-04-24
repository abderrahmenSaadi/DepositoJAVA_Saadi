import java.util.ArrayList;
import java.util.Scanner;

public class Zoo {

    private ArrayList<Animal> animals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Zoo() {
        // Default animals
        animals.add(new Dog("Poppy", 120, 25, 1.2));
        animals.add(new Cat("Misty", 80, 35, 1.8));
    }

    public void menu() {
        int choice;

        do {
            System.out.println("\n===== ZOO MENU =====");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Modify Animal");
            System.out.println("4. Show Animals");
            System.out.println("5. Fight");
            System.out.println("0. Exit");

            choice = readInt("Choose: ");

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    removeAnimal();
                    break;
                case 3:
                    modifyAnimal();
                    break;
                case 4:
                    showAnimals();
                    break;
                case 5:
                    fight();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    // ---------- SAFE INPUT METHODS ----------

    private int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                if (val >= 0) return val;
                System.out.println("Must be >= 0");
            } else if (scanner.hasNextDouble()) {
                int val = (int) scanner.nextDouble(); // convert double → int
                scanner.nextLine();
                return Math.max(val, 0);
            } else {
                System.out.println("Invalid number!");
                scanner.nextLine();
            }
        }
    }

    private double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine();
                if (val > 0) return val;
                System.out.println("Must be > 0");
            } else {
                System.out.println("Invalid number!");
                scanner.nextLine();
            }
        }
    }

    // ---------- ADD ----------

    private void addAnimal() {
        System.out.println("1. Dog\n2. Cat\n3. Custom");
        int type = readInt("Type: ");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        int hp = readInt("HP: ");
        int attack = readInt("Attack: ");
        double speed = readDouble("Attack Speed: ");

        switch (type) {
            case 1:
                animals.add(new Dog(name, hp, attack, speed));
                break;
            case 2:
                animals.add(new Cat(name, hp, attack, speed));
                break;
            case 3:
                System.out.print("Sound: ");
                String sound = scanner.nextLine();
                animals.add(new Animal(name, sound, hp, attack, speed));
                break;
            default:
                System.out.println("Invalid type");
        }
    }

    // ---------- SHOW ----------

    private void showAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals!");
            return;
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]"); // +1 for user
            animals.get(i).showStats();
        }
    }

    // ---------- REMOVE ----------

    private void removeAnimal() {
        showAnimals();

        int index = readInt("Index to remove: ") - 1;

        if (validIndex(index)) {
            animals.remove(index);
            System.out.println("Removed!");
        } else {
            System.out.println("Invalid index");
        }
    }

    // ---------- MODIFY ----------

    private void modifyAnimal() {
        showAnimals();

        int i = readInt("Index to modify: ") - 1;

        if (!validIndex(i)) {
            System.out.println("Invalid index");
            return;
        }

        Animal a = animals.get(i);

        a.hp = readInt("New HP: ");
        a.attack = readInt("New Attack: ");
        a.attackSpeed = readDouble("New Attack Speed: ");

        System.out.println("Updated!");
    }

    // ---------- FIGHT ----------

    private void fight() {
        if (animals.size() < 2) {
            System.out.println("Not enough animals!");
            return;
        }

        showAnimals();

        int i1 = readInt("First animal: ") - 1;
        int i2 = readInt("Second animal: ") - 1;

        if (!validIndex(i1) || !validIndex(i2) || i1 == i2) {
            System.out.println("Invalid selection");
            return;
        }

        Animal a1 = animals.get(i1);
        Animal a2 = animals.get(i2);

        double dps1 = a1.attack * a1.attackSpeed;
        double dps2 = a2.attack * a2.attackSpeed;

        double time1 = a2.hp / dps1;
        double time2 = a1.hp / dps2;

        System.out.println("\n--- FIGHT ---");
        System.out.println(a1.name + " vs " + a2.name);

        if (time1 < time2) {
            System.out.println("Winner: " + a1.name);
        } else if (time2 < time1) {
            System.out.println("Winner: " + a2.name);
        } else {
            System.out.println("Draw!");
        }
    }

    private boolean validIndex(int i) {
        return i >= 0 && i < animals.size();
    }
}