package de.bsinfo.game.pandarun.model;

import de.bsinfo.game.pandarun.Score.Score;
import de.bsinfo.game.pandarun.gfx.Assets;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;

public class Obstacles extends GameObject {

    public Obstacles(float x, float y) {
        super(x, y);
    }

    @Override
    public void update() {
        x -= Score.getGameSpeed();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.stoneObject, (int) x, (int) y, null);
    }
}
