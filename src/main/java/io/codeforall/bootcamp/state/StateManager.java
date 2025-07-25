package io.codeforall.bootcamp.state;

import com.codeforall.simplegraphics.keyboard.KeyboardEvent;

public class StateManager {

    private GameState currentState;

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void update() {
        if(currentState != null) {
            currentState.update();
        }
    }

    public void onKeyPress(KeyboardEvent event) {
        if(currentState != null) {
            currentState.onKeyPress(event);
        }
    }
}
