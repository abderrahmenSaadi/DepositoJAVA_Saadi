import java.util.ArrayList;
import java.util.Scanner;

// Main application class
public class PracticeTest {

    public static void main(String[] args) {

        // Store registered users
        ArrayList<User> users = new ArrayList<>();

        // Store calculation history
        ArrayList<String> results = new ArrayList<>();

        // Read user input
        Scanner scanner = new Scanner(System.in);

        // Control program termination
        boolean exit = false;

        // Count operations after login
        int operationsCount = 0;

        // Track login status
        boolean loggedIn = false;

        // Store current logged user
        String currentUser = "";

        // Display startup message
        System.out.println("Welcome to the Practice Test System!");

        // Main program loop
        while (!exit) {

            // Show authentication menu when logged out
            if (!loggedIn) {

                System.out.println("\n1. Sign Up");
                System.out.println("2. Sign In");
                System.out.println("3. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                // Handle login menu actions
                switch (choice) {

                    // Register new user
                    case 1:
                        System.out.print("Username: ");
                        String newUsername = scanner.nextLine();

                        System.out.print("Password: ");
                        String newPassword = scanner.nextLine();

                        signUp(users, new User(newUsername, newPassword));
                        break;

                    // Authenticate existing user
                    case 2:
                        System.out.print("Username: ");
                        String username = scanner.nextLine();

                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        if (signIn(users, username, password)) {
                            loggedIn = true;
                            currentUser = username;
                            operationsCount = 0;
                        }
                        break;

                    // Exit application
                    case 3:
                        exit = true;
                        break;

                    // Handle invalid option
                    default:
                        System.out.println("Invalid choice.");
                }

            } else {

                // Force logout after 4 operations
                if (operationsCount == 4) {
                    System.out.println("\nYou reached 4 operations. Login again.");
                    loggedIn = false;
                    operationsCount = 0;
                    continue;
                }

                // Show calculator menu
                System.out.println("\nLogged as: " + currentUser);
                System.out.println("1. Calculate");
                System.out.println("2. Show Results");
                System.out.println("3. Logout");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                // Handle logged-in actions
                switch (choice) {

                    // Start calculation process
                    case 1:
                        ArrayList<Double> numbers = new ArrayList<>();
                        ArrayList<String> operators = new ArrayList<>();

                        System.out.print("Enter first number: ");
                        double num = scanner.nextDouble();
                        scanner.nextLine();

                        numbers.add(num);

                        // Collect operators and remaining numbers
                        while (true) {
                            System.out.print("Enter operator (+ - * / ** or 'done' to calculate): ");
                            String op = scanner.nextLine();

                            if (op.equalsIgnoreCase("done")) {
                                break;
                            }

                            System.out.print("Enter next number: ");
                            num = scanner.nextDouble();
                            scanner.nextLine();

                            numbers.add(num);
                            operators.add(op);
                        }

                        // Validate minimum input
                        if (numbers.size() < 2) {
                            System.out.println("At least two numbers required.");
                            break;
                        }

                        // Execute calculation
                        Double result = calculate(numbers, operators);

                        // Save successful result
                        if (result != null) {
                            StringBuilder sb = new StringBuilder();

                            sb.append(numbers.get(0));

                            for (int i = 0; i < operators.size(); i++) {
                                sb.append(" ")
                                  .append(operators.get(i))
                                  .append(" ")
                                  .append(numbers.get(i + 1));
                            }

                            sb.append(" = ").append(result);

                            String text = sb.toString();

                            results.add(text);

                            System.out.println("Result: " + result);

                            operationsCount++;
                        }
                        break;

                    // Show stored history
                    case 2:
                        displayResults(results);
                        break;

                    // Logout current user
                    case 3:
                        loggedIn = false;
                        operationsCount = 0;
                        System.out.println("Logged out.");
                        break;

                    // Handle invalid option
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        // Release scanner resource
        scanner.close();
    }

    // Register user if username is unique
    static void signUp(ArrayList<User> users, User user) {

        for (User u : users) {
            if (u.username.equals(user.username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        users.add(user);
        System.out.println("User created.");
    }

    // Validate username and password
    static boolean signIn(ArrayList<User> users, String username, String password) {

        for (User user : users) {
            if (user.username.equals(username) &&
                user.password.equals(password)) {

                System.out.println("Login successful.");
                return true;
            }
        }

        System.out.println("Wrong username or password.");
        return false;
    }

    // Process arithmetic operations in sequence
    static Double calculate(ArrayList<Double> numbers, ArrayList<String> operators) {

        double result = numbers.get(0);

        for (int i = 0; i < operators.size(); i++) {

            String op = operators.get(i);
            double n = numbers.get(i + 1);

            switch (op) {

                case "+":
                    result += n;
                    break;

                case "-":
                    result -= n;
                    break;

                case "*":
                    result *= n;
                    break;

                case "/":
                    if (n == 0) {
                        System.out.println("Division by zero.");
                        return null;
                    }
                    result /= n;
                    break;

                case "**":
                    result = Math.pow(result, n);
                    break;

                default:
                    System.out.println("Invalid operator.");
                    return null;
            }
        }

        return result;
    }

    // Print calculation history
    static void displayResults(ArrayList<String> results) {

        if (results.isEmpty()) {
            System.out.println("No results.");
            return;
        }

        for (String r : results) {
            System.out.println(r);
        }
    }
}

// Data model for user credentials
class User {

    String username;
    String password;

    // Create new user instance
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}