import java.util.Scanner;

public class notificationSystem {

    public static void main(String[] args) {

        NotificationManager manager = NotificationManager.getInstance();
        Scanner scanner = new Scanner(System.in);
// Creazione utenti con decoratori personalizzati
User user1 = new User("User1",
        msg -> new UppercaseDecorator(
                    new TimestampDecorator(msg)
               )
);

User user2 = new User("User2",
        msg -> new PrefixDecorator(msg, "Notification: ")
);

User user3 = new User("User3",
        msg -> new EmojiDecorator(msg, ": )")
);

        boolean running = true;

        while (running) {
            System.out.println("\n===== Notification System Menu =====");
            System.out.println("1. Subscribe User1");
            System.out.println("2. Subscribe User2");
            System.out.println("3. Subscribe User3");
            System.out.println("4. Unsubscribe User1");
            System.out.println("5. Unsubscribe User2");
            System.out.println("6. Unsubscribe User3");
            System.out.println("7. Send Notification");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    manager.addObserver(user1);
                    System.out.println("User1 subscribed.");
                    break;

                case 2:
                    manager.addObserver(user2);
                    System.out.println("User2 subscribed.");
                    break;

                case 3:
                    manager.addObserver(user3);
                    System.out.println("User3 subscribed.");
                    break;

                case 4:
                    manager.removeObserver(user1);
                    System.out.println("User1 unsubscribed.");
                    break;

                case 5:
                    manager.removeObserver(user2);
                    System.out.println("User2 unsubscribed.");
                    break;

                case 6:
                    manager.removeObserver(user3);
                    System.out.println("User3 unsubscribed.");
                    break;

                case 7:
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();
                    manager.sendNotification(message);
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}