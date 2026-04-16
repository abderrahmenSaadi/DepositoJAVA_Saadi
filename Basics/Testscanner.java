package Basics;
import java.util.Scanner;

class Testscanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object to read input from the user
        System.out.println("Enter your name: "); // Prompt the user for their name
        String name = sc.nextLine(); // Read the user's input as a String
        System.out.println("Hello, " + name + "!"); // Greet the user with their name
    }
}