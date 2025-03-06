package design_pattern.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public interface Subject<T> {
    default void registerObserver(Observer<T> observer) {

    }

    default void removeObserver(Observer<T> observer) {

    }

    default void notifyObservers (T data) {

    }
}
