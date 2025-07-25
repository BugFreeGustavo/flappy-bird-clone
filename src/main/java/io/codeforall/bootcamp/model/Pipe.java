package io.codeforall.bootcamp.model;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;

public class Pipe {

    private static final int WIDTH = 40;
    private static final int GAP = 150;
    private Rectangle topPipe;
    private Rectangle bottomPipe;
    private int x;
    private int speed = 5;

    private boolean scored = false;

    public Pipe(int x, int height) {
        this.x = x;

        topPipe = new Rectangle(x, 10, WIDTH, height);
        topPipe.setColor(Color.GREEN);
        topPipe.fill();

        bottomPipe = new Rectangle(x, 10 + height + GAP, WIDTH, 600 - height - GAP);
        bottomPipe.setColor(Color.GREEN);
        bottomPipe.fill();
    }

    public void clear() {
        topPipe.delete();
        bottomPipe.delete();
    }

    public void move() {
        topPipe.translate(-speed, 0);
        bottomPipe.translate(-speed, 0);
        x -= speed;
    }

    public boolean collidesWith(Bird bird) {
        return bird.getShape().getX() + bird.getShape().getWidth() > x &&
                bird.getShape().getX() < x + WIDTH &&
                (bird.getShape().getY() < topPipe.getY() + topPipe.getHeight() ||
                        bird.getShape().getY() + bird.getShape().getHeight() > bottomPipe.getY());
    }

    public int getX() {
        return x;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }
}
