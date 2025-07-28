package io.codeforall.bootcamp.state;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import io.codeforall.bootcamp.manager.GameManager;
import io.codeforall.bootcamp.model.Bird;
import io.codeforall.bootcamp.strategy.Difficulty;
import io.codeforall.bootcamp.strategy.DifficultyManager;
import io.codeforall.bootcamp.view.GameView;

public class MenuState implements GameState {

    private StateManager stateManager;
    private Text title;
    private Text instructions;
    private Text difficultyText;

    private Difficulty selectedDifficulty = Difficulty.NORMAL;

    public MenuState(StateManager stateManager) {
        this.stateManager = stateManager;
        showMenu();
    }

    public void showMenu() {
        title = new Text(400, 200, "FLAPPY CADET JAVA");
        title.grow(50, 20);
        title.draw();

        instructions = new Text(260, 250, "PRESS <ENTER> TO START");
        instructions.grow(20, 10);
        instructions.draw();

        difficultyText = new Text(260, 280, "PRESS 1: EASY | 2: NORMAL | 3: HARD");
        difficultyText.grow(10, 5);
        difficultyText.draw();
    }

    public void clearMenu() {
        title.delete();
        instructions.delete();
        difficultyText.delete();
    }

    @Override
    public void update() {

    }

    @Override
    public void onKeyPress(KeyboardEvent event) {
        switch (event.getKey()) {
            case KeyboardEvent.KEY_1:
                selectedDifficulty = Difficulty.EASY;
                break;

            case KeyboardEvent.KEY_2:
                selectedDifficulty = Difficulty.NORMAL;
                break;

            case KeyboardEvent.KEY_3:
                selectedDifficulty = Difficulty.HARD;
                break;

            case KeyboardEvent.KEY_ENTER:
                clearMenu();
                startGame();
                break;
        }
    }

    public void startGame() {
        Bird bird = new Bird();
        bird.setFlyBehavior(DifficultyManager.getFlyBehaviour(selectedDifficulty));

        GameView view = new GameView();
        view.init();
        bird.drawBird();
        view.drawScore();

        GameManager.getInstance().resetScore();
        GameManager.getInstance().setRunning(true);

        stateManager.setState(new PlayingState(stateManager, bird, view));
    }
}
