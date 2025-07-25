package io.codeforall.bootcamp.view;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;
import com.codeforall.simplegraphics.graphics.Text;
import io.codeforall.bootcamp.manager.GameManager;
import io.codeforall.bootcamp.observer.Observer;

public class GameView implements Observer {

    private Text scoreText;
    private Text gameOverText;

    public void init() {
        Rectangle background = new Rectangle(10,10,800,600);
        background.setColor(Color.CYAN);
        background.fill();

        GameManager.getInstance().addObserver(this);
    }

    public void drawScore() {
        scoreText = new Text(40,30, "Score: 0");
        scoreText.grow(20,10);
        scoreText.draw();
    }

    public void updateScore(int score) {
        scoreText.setText("Score: " + score);
    }

    @Override
    public void update() {
        int score = GameManager.getInstance().getScore();
        updateScore(score);
    }

    public void showGameOver() {
        gameOverText = new Text(340,300,"GAME OVER");
        gameOverText.grow(50,20);
        gameOverText.draw();
    }

    public void clearGameOver() {
        if(gameOverText != null) {
            gameOverText.delete();
        }
    }
}
