package io.codeforall.bootcamp.strategy;

import io.codeforall.bootcamp.model.Bird;

public class NormalFly implements FlyBehavior{
    @Override
    public void applyGravity(Bird bird) {
        bird.increaseVelocity(2);
    }
}
