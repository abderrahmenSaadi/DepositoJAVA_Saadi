package view;

public class MenuView {

    public static void showMainMenu() {

        System.out.println("\n===== TICKET SYSTEM =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }

    public static void showUserMenu() {

        System.out.println("\n===== USER MENU =====");
        System.out.println("1. Create Ticket");
        System.out.println("2. View My Tickets");
        System.out.println("3. Logout");
    }

    public static void showAdminMenu() {

        System.out.println("\n===== ADMIN MENU =====");
        System.out.println("1. View All Tickets");
        System.out.println("2. Resolve Ticket");
        System.out.println("3. Delete Ticket");
        System.out.println("4. Logout");
    }
}