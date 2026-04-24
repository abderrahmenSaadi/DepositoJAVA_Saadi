// MAIN
import java.util.ArrayList;
import java.util.Scanner;   

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Hotel> hotels = new ArrayList<>();
        int currentHotelIndex = -1;

        while (true) {
            System.out.println("\n===== HOTEL MENU =====");
            if (currentHotelIndex != -1)
                System.out.println("Current hotel: " + hotels.get(currentHotelIndex).getNome());
            else
                System.out.println("No hotel selected");

            System.out.println("1. Create hotel");
            System.out.println("2. Switch hotel");
            System.out.println("3. Add room");
            System.out.println("4. Remove room");
            System.out.println("5. Show rooms");
            System.out.println("6. Show map");
            System.out.println("7. Count suites");
            System.out.println("0. Exit");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    sc.nextLine(); 
                    System.out.print("Hotel name: ");
                    String name = sc.nextLine();

                    System.out.print("Floors: ");
                    int f = sc.nextInt();
                    System.out.print("Rows: ");
                    int r = sc.nextInt();
                    System.out.print("Cols: ");
                    int c = sc.nextInt();

                    if (f <= 0 || r <= 0 || c <= 0) {
                        System.out.println("Invalid dimensions.");
                        break;
                    }

                    hotels.add(new Hotel(name, f, r, c));
                    currentHotelIndex = hotels.size() - 1;
                    break;

                case 2:
                    if (hotels.isEmpty()) {
                        System.out.println("No hotels available.");
                        break;
                    }
                    for (int i = 0; i < hotels.size(); i++)
                        System.out.println((i + 1) + ". " + hotels.get(i).getNome());

                    int idx = sc.nextInt() - 1;
                    if (idx < 0 || idx >= hotels.size()) {
                        System.out.println("Invalid selection.");
                    } else {
                        currentHotelIndex = idx;
                    }
                    break;

                case 3:
                    if (currentHotelIndex == -1) break;

                    System.out.print("Room number: ");
                    int num = sc.nextInt();
                    System.out.print("Price: ");
                    float price = sc.nextFloat();

                    System.out.print("Is suite? (1 yes / 0 no): ");
                    int isSuite = sc.nextInt();

                    sc.nextLine();
                    Camera room;
                    if (isSuite == 1) {
                        System.out.print("Extra services: ");
                        String extra = sc.nextLine();
                        room = new Suite(num, price, extra);
                    } else {
                        room = new Camera(num, price);
                    }

                    System.out.print("Floor (1-based): ");
                    int fl = sc.nextInt() - 1;
                    System.out.print("Row (1-based): ");
                    int ro = sc.nextInt() - 1;
                    System.out.print("Col (1-based): ");
                    int co = sc.nextInt() - 1;

                    boolean added = hotels.get(currentHotelIndex).aggiungiCamera(room, fl, ro, co);
                    if (!added)
                        System.out.println("Invalid position or already occupied.");

                    break;

                case 4:
                    if (currentHotelIndex == -1) break;
                    System.out.print("Room number to remove: ");
                    int rem = sc.nextInt();

                    if (!hotels.get(currentHotelIndex).rimuoviCamera(rem))
                        System.out.println("Room not found.");

                    break;

                case 5:
                    if (currentHotelIndex == -1) break;
                    hotels.get(currentHotelIndex).stampaCamere();
                    break;

                case 6:
                    if (currentHotelIndex == -1) break;
                    hotels.get(currentHotelIndex).stampaMappa();
                    break;

                case 7:
                    if (currentHotelIndex == -1) break;
                    int count = Hotel.contaSuite(hotels.get(currentHotelIndex).getCamere());
                    System.out.println("Total suites: " + count);
                    break;

                case 0:
                    return;
            }
        }
    }
}
