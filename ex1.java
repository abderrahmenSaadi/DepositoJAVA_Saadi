import java.util.Scanner;
public class ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object 
        System.out.println("Enter your age: ");// Prompt the user for input 
        Integer age = sc.nextInt(); // Read the user's input as a String
        System.out.println("Your age is: " + age); // Print the user's input
        System.out.println("Do you have a ticket? " );// Prompt the user for input
        Boolean hasTicket = sc.nextBoolean();
        System.out.println("Do you have a ticket? " + hasTicket); // Print the user's input
        System.out.println("are you with adult: " );// Prompt the user for input
        Boolean isWithAdult = sc.nextBoolean();
        System.out.println("are you with adult? " + isWithAdult); // Print the user's input
        System.out.println("Do you purshased the option skip line       ? " );// Prompt the user for input
        Boolean skipLine = sc.nextBoolean();
        System.out.println("Do you purshased the option skip line? " + skipLine); // Print the user's input
        sc.close(); // Close the Scanner
    }
    
}
