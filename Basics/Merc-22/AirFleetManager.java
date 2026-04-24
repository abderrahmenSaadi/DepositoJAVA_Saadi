import java.util.ArrayList;
import java.util.Scanner;

public class AirFleetManager {

    //  Safe integer input
    public static int readInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                System.out.println("Invalid number!");
                sc.nextLine();
            }
        }
    }

    //  Safe string input
    public static String readString(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.trim().isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    //  Show airlines and choose by number
    public static int chooseAirlineIndex(ArrayList<CompagniaAerea> airlines, Scanner sc) {
        if (airlines.isEmpty()) {
            System.out.println("No airlines available.");
            return -1;
        }

        System.out.println("\n--- Airlines ---");
        for (int i = 0; i < airlines.size(); i++) {
            System.out.println((i + 1) + ". " + airlines.get(i).getNome());
        }

        int choice;
        while (true) {
            choice = readInt(sc, "Select airline (number): ");
            if (choice >= 1 && choice <= airlines.size()) {
                return choice - 1;
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<CompagniaAerea> airlines = new ArrayList<>();
        CompagniaAerea current = null;

        int choice;

        do {
            System.out.println("\n===== AIRLINE SYSTEM =====");
            System.out.println("Current: " + (current != null ? current.getNome() : "NONE"));
            System.out.println("1. Create airline");
            System.out.println("2. Select airline");
            System.out.println("3. Remove airline");
            System.out.println("4. Add airplane");
            System.out.println("5. Add pilot");
            System.out.println("6. Show current airline");
            System.out.println("0. Exit");

            choice = readInt(sc, "Choice: ");

            switch (choice) {

                //  CREATE
                case 1:
                    String name = readString(sc, "Airline name: ");

                    boolean exists = false;
                    for (CompagniaAerea c : airlines) {
                        if (c.getNome().equalsIgnoreCase(name)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Airline already exists.");
                    } else {
                        airlines.add(new CompagniaAerea(name));
                        System.out.println("Airline created.");
                    }
                    break;

                //  SELECT (by number)
                case 2:
                    int indexSelect = chooseAirlineIndex(airlines, sc);

                    if (indexSelect != -1) {
                        current = airlines.get(indexSelect);
                        System.out.println("Selected: " + current.getNome());
                    }
                    break;

                //  REMOVE (by number)
                case 3:
                    int indexRemove = chooseAirlineIndex(airlines, sc);

                    if (indexRemove != -1) {
                        CompagniaAerea removed = airlines.remove(indexRemove);

                        if (current == removed) {
                            current = null;
                        }

                        System.out.println("Removed: " + removed.getNome());
                    }
                    break;

                //  REQUIRE SELECTED AIRLINE
                case 4:
                    if (current == null) {
                        System.out.println("Select an airline first.");
                        break;
                    }

                    String model = readString(sc, "Model: ");

                    int seats;
                    while (true) {
                        seats = readInt(sc, "Seats (>0): ");
                        if (seats > 0) break;
                        System.out.println("Seats must be > 0.");
                    }

                    String code = readString(sc, "Code: ");

                    current.aggiungiAereo(new Aereo(model, seats, code));
                    System.out.println("Airplane added.");
                    break;

                case 5:
                    if (current == null) {
                        System.out.println("Select an airline first.");
                        break;
                    }

                    String pilotName = readString(sc, "Pilot name: ");
                    String license = readString(sc, "License: ");

                    int hours;
                    while (true) {
                        hours = readInt(sc, "Flight hours (>0): ");
                        if (hours > 0) break;
                        System.out.println("Must be > 0.");
                    }

                    current.aggiungiPilota(new Pilota(pilotName, license, hours));
                    System.out.println("Pilot added.");
                    break;

                case 6:
                    if (current == null) {
                        System.out.println("Select an airline first.");
                    } else {
                        current.stampaInfo();
                    }
                    break;

                case 0:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}