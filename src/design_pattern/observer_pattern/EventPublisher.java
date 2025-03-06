package design_pattern.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class EventPublisher<T> implements Subject<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers (T data) {
        for(Observer<T> observer: observers) {
            observer.update(data);
        }
    }

    // Method to publish events
    public void publishEvent(String event) {
        System.out.println("New Event Published: " + event);
        notifyObservers((T) event);
    }
}
