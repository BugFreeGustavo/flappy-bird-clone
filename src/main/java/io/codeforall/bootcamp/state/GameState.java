package io.codeforall.bootcamp.state;

import com.codeforall.simplegraphics.keyboard.KeyboardEvent;

public interface GameState {

    void update();
    void onKeyPress(KeyboardEvent event);
}
