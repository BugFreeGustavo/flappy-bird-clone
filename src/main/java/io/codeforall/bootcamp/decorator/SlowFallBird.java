package io.codeforall.bootcamp.decorator;

import io.codeforall.bootcamp.model.Bird;

public class SlowFallBird extends BirdDecorator{

    public SlowFallBird(Bird decoratedBird) {
        super(decoratedBird);
    }

    @Override
    public void applyGravity() {
        decoratedBird.increaseVelocity(1);

        if(decoratedBird.getVelocity() > 10) {
            decoratedBird.setVelocity(10);
        }

        if(decoratedBird.getShape().getY() + decoratedBird.getShape().getHeight() + decoratedBird.getVelocity() < 610) {
            decoratedBird.getShape().translate(0, decoratedBird.getVelocity());
        }
    }
}
