package io.codeforall.bootcamp.strategy;

import io.codeforall.bootcamp.model.Bird;

public interface FlyBehavior {

    void applyGravity(Bird bird);
}
