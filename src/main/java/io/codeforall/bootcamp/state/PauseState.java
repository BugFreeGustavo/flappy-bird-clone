package io.codeforall.bootcamp.state;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;

public class PauseState implements GameState {

    private StateManager stateManager;
    private GameState previousState;
    private Text pausedText;

    public PauseState(StateManager stateManager, GameState previousState) {
        this.stateManager = stateManager;
        this.previousState = previousState;

        pausedText = new Text(300,300, "GAME PAUSED");
        pausedText.grow(30,15);
        pausedText.draw();
    }

    @Override
    public void update() {

    }

    @Override
    public void onKeyPress(KeyboardEvent event) {
        if(event.getKey() == KeyboardEvent.KEY_ESC) {
            pausedText.delete();
            stateManager.setState(previousState);
        }
    }
}
