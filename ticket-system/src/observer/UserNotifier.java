package observer;

public class UserNotifier implements Observer {

    @Override
    public void update(String message) {
        System.out.println("[USER NOTIFICATION] " + message);
    }
}