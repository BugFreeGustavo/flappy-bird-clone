package io.codeforall.bootcamp.model;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Rectangle;
import io.codeforall.bootcamp.strategy.FlyBehavior;
import io.codeforall.bootcamp.strategy.NormalFly;

public class Bird {

    private Rectangle shape;
    private int velocity = 0;
    private final int MAX_FALL_SPEED = 10;

    private FlyBehavior flyBehavior = new NormalFly();

    public Bird() {
        shape = new Rectangle(100, 250, 20, 20);
        shape.setColor(Color.YELLOW);
    }

    public void drawBird() {
        shape.fill();
    }

    public void reset() {
        shape.delete();
        shape = new Rectangle(100, 250, 20, 20);
        shape.setColor(Color.YELLOW);
        shape.fill();
        velocity = 0;
    }

    public void applyGravity() {
        flyBehavior.applyGravity(this);

        if (velocity > MAX_FALL_SPEED) {
            velocity = MAX_FALL_SPEED;
        }

        if (shape.getY() + shape.getHeight() + velocity < 610) {
            shape.translate(0, velocity);
        }
    }

    public void jump() {
        velocity = -10;
    }

    public void increaseVelocity(int value) {
        velocity += value;
    }

    public Rectangle getShape() {
        return shape;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
