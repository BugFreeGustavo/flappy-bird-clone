package io.codeforall.bootcamp.strategy;

public class DifficultyManager {

    public static FlyBehavior getFlyBehaviour(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> new LightFly();
            case HARD -> new HeavyFly();
            default -> new NormalFly();
        };
    }
}
