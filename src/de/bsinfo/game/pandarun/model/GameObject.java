package de.bsinfo.game.pandarun.model;

import java.awt.*;

public abstract class GameObject {

    float x, y;

    GameObject(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}
