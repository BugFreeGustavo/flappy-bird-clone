package io.codeforall.bootcamp.util;

import com.codeforall.simplegraphics.graphics.Canvas;
import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;
import io.codeforall.bootcamp.controller.GameController;

public class Bootstrap {

    private Rectangle canvas;

    private final int PADDING = 10;
    private final int CELL_SIZE = 10;
    private final int cols = 80;
    private final int rows = 60;

    public Bootstrap() {
        canvas = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        canvas.setColor(Color.BLACK);
        canvas.fill();

        Canvas.setMaxX(cols * CELL_SIZE);
    }

    public void start() {
        GameController gameController = new GameController();
        gameController.start();
    }
}
