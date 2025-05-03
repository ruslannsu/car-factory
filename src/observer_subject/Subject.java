package observer_subject;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver();
    void notifyObservers();
}
