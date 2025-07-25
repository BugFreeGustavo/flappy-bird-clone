package io.codeforall.bootcamp.manager;

import io.codeforall.bootcamp.observer.Observable;
import io.codeforall.bootcamp.observer.Observer;
import io.codeforall.bootcamp.state.StateManager;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements Observable {

    private static GameManager instance;

    private StateManager stateManager;
    private boolean running;
    private int score;

    private List<Observer> observers = new ArrayList<>();

    private GameManager() {
        stateManager = new StateManager();
        score = 0;
        running = true;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void increaseScore() {
        score++;
        notifyObservers();
    }
    public void resetScore() {
        score = 0;
        notifyObservers();
    }

    public int getScore() {
        return score;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: observers) {
            obs.update();
        }
    }
    public StateManager getStateManager() {
        return stateManager;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
