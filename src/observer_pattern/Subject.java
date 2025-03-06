package observer_pattern;

public interface Subject<T> {
    default void registerObserver(Observer<T> observer) {

    }

    default void removeObserver(Observer<T> observer) {

    }

    default void notifyObservers (T data) {

    }
}
