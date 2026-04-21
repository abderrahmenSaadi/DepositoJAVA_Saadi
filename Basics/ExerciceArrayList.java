
import java.util.ArrayList;
import java.util.Scanner;
public class ExerciceArrayList {

        public static void main(String[] args) {
            // Create an ArrayList to store names and a Scanner for user input
            ArrayList<String> names = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            String name;
            // Input names until user types "fine"
            do {
                System.out.println("Enter the  names you want to add: ");
                name = sc.nextLine();
                if (!name.equals("fine")) {
                    names.add(name);
                }
            } while (!name.equals("fine"));
            names.sort(null);
            System.out.println("Names in alphabetical order: " + names);
            System.out.println("Size of the list: " + names.size());
            String response;
            do {
                System.out.println("Do you want to remove names? (yes/no): ");
                response = sc.nextLine();
                while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
                    System.out.println("Please enter 'yes' or 'no': ");
                    response = sc.nextLine();
                }
                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("Enter the name you want to remove: ");
                    String nameToRemove = sc.nextLine();
                    if (names.remove(nameToRemove)) {
                        System.out.println(nameToRemove + " removed from the list.");
                        System.out.println("Updated list: " + names);
                    } else {
                        System.out.println(nameToRemove + " not found in the list.");
                    }
                }
            } while (response.equalsIgnoreCase("yes"));

        }
    
}
