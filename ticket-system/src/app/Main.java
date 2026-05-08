package app;

import facade.SystemFacade;
import model.user.Role;
import util.InputValidator;
import util.SessionManager;
import view.MenuView;

import java.util.Scanner;
public class Main {
     public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SystemFacade facade = new SystemFacade();

        boolean running = true;

        while (running) {

            MenuView.showMainMenu();

            int choice = InputValidator.readInt(scanner);

            switch (choice) {

case 1:

    System.out.print("Username: ");
    String username = scanner.nextLine();

    System.out.print("Password: ");
    String password = scanner.nextLine();

    System.out.println("1. USER");
    System.out.println("2. ADMIN");

    int roleChoice = InputValidator.readInt(scanner);

    Role role = Role.USER;
    String adminSecret = System.getenv("ADMIN_SECRET_KEY");

    if (roleChoice == 2) {

        System.out.print("Enter admin secret key: ");
        String secretKey = scanner.nextLine();

        if (secretKey.equals(adminSecret)) {

            role = Role.ADMIN;

        } else {

            System.out.println("Invalid admin secret key.");
            continue;
        }
    }

    facade.getAuthenticationFacade().register(username, password, role);

    break;
                case 2:

                    System.out.print("Username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = scanner.nextLine();

                    boolean logged = facade.getAuthenticationFacade().login(loginUsername, loginPassword);

                    if (!logged) {
                        System.out.println("Wrong credentials.");
                        break;
                    }

                    if (SessionManager.getInstance().getLoggedUser().getRole() == Role.USER) {

                        boolean userMenu = true;

                        while (userMenu) {

                            MenuView.showUserMenu();

                            int userChoice = InputValidator.readInt(scanner);

                            switch (userChoice) {case 1:

                                    System.out.print("Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Description: ");
                                    String description = scanner.nextLine();

                                    facade.getTicketFacade().createTicket(
                                            title,
                                            description,
                                            SessionManager.getInstance().getLoggedUser().getId()
                                    );

                                    break;

                                case 2:

                                    facade.getTicketFacade().showUserTickets(
                                            SessionManager.getInstance().getLoggedUser().getId()
                                    );

                                    break;

                                case 3:

                                    facade.getAuthenticationFacade().logout();
                                    userMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }
                        }

                    } else { boolean adminMenu = true;

                        while (adminMenu) {

                            MenuView.showAdminMenu();

                            int adminChoice = InputValidator.readInt(scanner);

                            switch (adminChoice) {

                                case 1:

                                    facade.getTicketFacade().showAllTickets();
                                    break;

                                case 2:

                                    System.out.print("Ticket ID: ");
                                    int resolveId = InputValidator.readInt(scanner);

                                    facade.getTicketFacade().resolveTicket(resolveId);
                                    break;

                                case 3:

                                    System.out.print("Ticket ID: ");
                                    int deleteId = InputValidator.readInt(scanner);

                                    facade.getTicketFacade().deleteTicket(deleteId);
                                    break; case 4:

                                    facade.getAuthenticationFacade().logout();
                                    adminMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }
                        }
                    }

                    break;

                case 3:

                    running = false;
                    System.out.println("Application closed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

