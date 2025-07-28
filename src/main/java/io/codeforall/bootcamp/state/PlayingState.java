package io.codeforall.bootcamp.state;

import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import io.codeforall.bootcamp.decorator.SlowFallBird;
import io.codeforall.bootcamp.factory.PipeFactory;
import io.codeforall.bootcamp.manager.GameManager;
import io.codeforall.bootcamp.model.Bird;
import io.codeforall.bootcamp.model.Pipe;
import io.codeforall.bootcamp.view.GameView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayingState implements GameState {

    private StateManager stateManager;
    private Bird bird;
    private GameView view;
    private List<Pipe> pipes;

    private int pipeTimer = 0;
    private final int PIPE_INTERVAL = 100;

    public PlayingState(StateManager stateManager, Bird bird, GameView view) {
        this.stateManager = stateManager;
        this.bird = bird;
        this.view = view;
        this.pipes = new ArrayList<>();
    }

    @Override
    public void update() {
        bird.applyGravity();
        updatePipes();
    }

    private void updatePipes() {
        pipeTimer++;

        if (pipeTimer >= PIPE_INTERVAL) {
            pipes.add(PipeFactory.createPipe());
            pipeTimer = 0;
        }

        Iterator<Pipe> iterator = pipes.iterator();
        while (iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.move();

            if (!pipe.isScored() && pipe.getX() + 40 < bird.getShape().getX()) {
                GameManager.getInstance().increaseScore();
                pipe.setScored(true);
            }

            if (pipe.getX() + 40 < 0) {
                pipe.clear();
                iterator.remove();
            }

            if (pipe.collidesWith(bird)) {
                view.showGameOver();
                stateManager.setState(new GameOverState(stateManager, bird, view, pipes));
                return;
            }

            if(GameManager.getInstance().getScore() == 15) {
                bird = new SlowFallBird(bird);
            }
        }
    }

    @Override
    public void onKeyPress(KeyboardEvent event) {
        if (event.getKey() == KeyboardEvent.KEY_SPACE) {
            bird.jump();

        } else if(event.getKey() == KeyboardEvent.KEY_ESC) {
            stateManager.setState(new PauseState(stateManager, this));
        }
    }
}
