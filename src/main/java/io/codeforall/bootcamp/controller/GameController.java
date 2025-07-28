package io.codeforall.bootcamp.controller;

import com.codeforall.simplegraphics.keyboard.Keyboard;
import com.codeforall.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.simplegraphics.keyboard.KeyboardHandler;
import io.codeforall.bootcamp.manager.GameManager;
import io.codeforall.bootcamp.model.Bird;

import io.codeforall.bootcamp.state.MenuState;

import io.codeforall.bootcamp.strategy.Difficulty;
import io.codeforall.bootcamp.strategy.DifficultyManager;
import io.codeforall.bootcamp.view.GameView;

public class GameController implements KeyboardHandler {

    private GameManager gameManager;
    private Bird bird;
    private GameView view;

    public void start() {
        gameManager = GameManager.getInstance();
        bird = new Bird();
        view = new GameView();
        view.init();
        bird.drawBird();
        view.drawScore();

        gameManager.getStateManager().setState(
                new MenuState(gameManager.getStateManager()));

        initKeyboard();
        Difficulty difficulty = Difficulty.HARD;
        bird.setFlyBehavior(DifficultyManager.getFlyBehaviour(difficulty));
        startGameLoop();
    }

    private void startGameLoop() {
        Thread gameLoop = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20);   // 50 FPS

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (gameManager.isRunning()) {
                    gameManager.getStateManager().update();
                }
            }
        });
        gameLoop.start();
    }

    private void initKeyboard() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

        KeyboardEvent restart = new KeyboardEvent();
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restart.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(restart);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        enter.setKey(KeyboardEvent.KEY_ENTER);
        keyboard.addEventListener(enter);

        KeyboardEvent key1 = new KeyboardEvent();
        key1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key1.setKey(KeyboardEvent.KEY_1);
        keyboard.addEventListener(key1);

        KeyboardEvent key2 = new KeyboardEvent();
        key2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key2.setKey(KeyboardEvent.KEY_2);
        keyboard.addEventListener(key2);

        KeyboardEvent key3 = new KeyboardEvent();
        key3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        key3.setKey(KeyboardEvent.KEY_3);
        keyboard.addEventListener(key3);

        KeyboardEvent pause = new KeyboardEvent();
        pause.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pause.setKey(KeyboardEvent.KEY_ESC);
        keyboard.addEventListener(pause);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        gameManager.getStateManager().onKeyPress(keyboardEvent);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
