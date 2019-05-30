package de.bsinfo.game.pandarun.Entity;

import java.awt.*;

public abstract class GameObject {

    float x, y;

    GameObject(float x, float y){
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}
