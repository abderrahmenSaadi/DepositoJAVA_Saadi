import java.util.Scanner;

public class exercicearray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String[] menu = {"Cornetto", "Biscot", "Cannolo", "Tiramisu", "Crostata"};
        double[] prices = {1.0, 0.5, 2.0, 3.5, 2.5};

        // Arrays for user order
        String[] desserts = new String[10];
        int[] quantities = new int[10];

        int numDesserts;

        do {
            System.out.print("How many different desserts do you want to order (max 10)? "); // Input validation
            numDesserts = scanner.nextInt();
        } while (numDesserts < 1 || numDesserts > 10); // Validate number of desserts


        // Display menu
        System.out.println("\nMenu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - euro " + prices[i]);
        }

        // User menu  choice  with validation
        for (int i = 0; i < numDesserts; i++) {
            int choice;

            do {
                System.out.print("\nSelect dessert number: ");
                choice = scanner.nextInt();
            } while (choice < 1 || choice > menu.length);

            desserts[i] = menu[choice - 1];

            // Quantity with validation
            do {
                System.out.print("Enter quantity: ");
                quantities[i] = scanner.nextInt();

                if (quantities[i] < 0) {
                    System.out.println("Error: Quantity cannot be negative. Try again.");
                }

            } while (quantities[i] < 0);
        }

        // Output results
        int totalQuantity = 0;
        double totalCost = 0;

        System.out.println("\n--- Orders ---");

        for (int i = 0; i < numDesserts; i++) {
            System.out.println(desserts[i] + " x " + quantities[i]);
            totalQuantity += quantities[i];

            // Find price
            for (int j = 0; j < menu.length; j++) {
                if (desserts[i].equals(menu[j])) {
                    totalCost += quantities[i] * prices[j];
                }
            }
        }

        System.out.println("\nTotal quantity: " + totalQuantity);
        System.out.println("Total cost:  " + totalCost + " euro");

        scanner.close();
    }
}

