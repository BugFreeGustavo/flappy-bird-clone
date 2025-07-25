package io.codeforall.bootcamp.decorator;

import com.codeforall.simplegraphics.graphics.Rectangle;
import io.codeforall.bootcamp.model.Bird;
import io.codeforall.bootcamp.strategy.FlyBehavior;

public class BirdDecorator extends Bird {

    protected Bird decoratedBird;

    public BirdDecorator(Bird decoratedBird) {
        this.decoratedBird = decoratedBird;
    }

    @Override
    public void applyGravity() {
        decoratedBird.applyGravity();
    }

    @Override
    public void jump() {
        decoratedBird.jump();
    }

    @Override
    public void reset() {
        decoratedBird.reset();
    }

    @Override
    public void drawBird() {
        decoratedBird.drawBird();
    }

    @Override
    public void setFlyBehavior(FlyBehavior behavior) {
        decoratedBird.setFlyBehavior(behavior);
    }

    @Override
    public FlyBehavior getFlyBehavior() {
        return decoratedBird.getFlyBehavior();
    }

    @Override
    public Rectangle getShape() {
        return decoratedBird.getShape();
    }
}
