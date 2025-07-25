package io.codeforall.bootcamp.state;

import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import io.codeforall.bootcamp.manager.GameManager;
import io.codeforall.bootcamp.model.Bird;
import io.codeforall.bootcamp.model.Pipe;
import io.codeforall.bootcamp.view.GameView;

import java.util.List;

public class GameOverState implements GameState {

    private StateManager stateManager;
    private Bird bird;
    private GameView view;
    private List<Pipe> pipes;

    public GameOverState(StateManager stateManager, Bird bird,  GameView view, List<Pipe> pipes) {
        this.stateManager = stateManager;
        this.bird = bird;
        this.view = view;
        this.pipes = pipes;
    }

    @Override
    public void update() {

    }

    @Override
    public void onKeyPress(KeyboardEvent event) {
        if(event.getKey() == KeyboardEvent.KEY_R) {

            for(Pipe pipe: pipes) {
                pipe.clear();
            }
            pipes.clear();

            bird.reset();
            view.clearGameOver();

            GameManager.getInstance().resetScore();
            view.updateScore(0);

            GameManager.getInstance().setRunning(true);
            stateManager.setState(new PlayingState(stateManager, bird, view));
        }
    }
}
