import java.util.HashSet;
import java.util.Set;

interface EventObserver {
    void update(String event);
}


class EventNotifier {
    private Set<EventObserver> observers = new HashSet<>();

    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EventObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String event) {
        for (EventObserver observer : observers) {
            observer.update(event);
        }
    }
}