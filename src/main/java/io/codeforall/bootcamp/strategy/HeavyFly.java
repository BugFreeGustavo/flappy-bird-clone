package io.codeforall.bootcamp.strategy;

import io.codeforall.bootcamp.model.Bird;

public class HeavyFly implements FlyBehavior {

    @Override
    public void applyGravity(Bird bird) {
        bird.increaseVelocity(4);
    }
}
