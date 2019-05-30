package de.bsinfo.game.pandarun.state;

import de.bsinfo.game.pandarun.code.Game;

import java.awt.*;

public abstract class State {

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}