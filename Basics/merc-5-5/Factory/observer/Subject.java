public interface Subject {
    // Methods to manage observers
    void addObserver(Observer o); // Add an observer to the list
    void removeObserver(Observer o); // Remove an observer from the list
    void notifyObservers(); // Notify all observers of a change
}