package io.codeforall.bootcamp.factory;

import io.codeforall.bootcamp.model.Pipe;

public class PipeFactory {

    private static final int MIN_HEIGHT = 100;
    private static final int MAX_HEIGHT = 350;
    private static final int START_X = 800;

    public static Pipe createPipe() {
        int height = MIN_HEIGHT + (int)(Math.random()) * (MAX_HEIGHT - MIN_HEIGHT);
        return new Pipe(START_X, height);
    }
}
