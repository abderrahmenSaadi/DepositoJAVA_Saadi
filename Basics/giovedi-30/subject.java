interface subject {

    void registerObserver(observer o);
    void removeObserver(observer o);
    void notifyObservers();
}