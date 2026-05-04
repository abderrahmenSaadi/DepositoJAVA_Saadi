// NotificationManager.java
import java.util.ArrayList;
import java.util.List;

public class NotificationManager {

    private static NotificationManager instance;
    private List<Observer> observers;

    private NotificationManager() {
        observers = new ArrayList<>();
    }

    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void sendNotification(String messageContent) {
        Message message = new BasicMessage(messageContent);

        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}