import java.util.Scanner;

public class exercicewhile {
    public static void main(String[] args) {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String password = sc.nextLine();
        while (!password.equals("Java123") && i < 3) {
            System.out.println("Incorrect password. Please try again.");
            System.out.println("Enter a password: ");
            password = sc.nextLine();
            i++;
        }
        if (password.equals("Java123")) {
        System.out.println("Password correct. Access granted.");
        
        
        System.out.println("Do you want to acces to the system s/n");
        String answer = sc2.nextLine();
        switch (answer) {
            case "s":
                System.out.println("Accessing system...");
                break;
            case "n":
                System.out.println("Exiting system...");    
        
            default:
                break;
        }
        sc2.close();
        }
        else {
            System.out.println("Too many attempts. Access denied.");
        }


    }

}