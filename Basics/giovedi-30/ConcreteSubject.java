
import java.util.ArrayList;
import java.util.List;
public class ConcreteSubject implements subject {
    private List<observer> observers = new ArrayList<>();
    private String state;
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (observer o : observers) {
            o.update(state);
        }
    
}
}