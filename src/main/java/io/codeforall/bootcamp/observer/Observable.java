package io.codeforall.bootcamp.observer;

public interface Observable {

    void addObserver(Observer observer);
    void notifyObservers();
}
