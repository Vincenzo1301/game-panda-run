package de.bsinfo.game.pandarun.model;

import de.bsinfo.game.pandarun.gfx.Assets;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Obstacle extends GameObject {

    private BufferedImage bufferedImage;

    public Obstacle(float x, float y) {
        super(x, y);
        generateRandomBufferedImage();
    }

    private void generateRandomBufferedImage() {
        Random random = new Random();
        final int randomNumber = random.nextInt(2);
        if(randomNumber == 0) {
            bufferedImage = Assets.stoneObject;
        } else {
            bufferedImage = Assets.trunkObject;
            y -= 20;
        }
    }

    @Override
    public void update() {
        x -= Score.getGameSpeed();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bufferedImage, (int) x, (int) y, null);
    }

    @Override
    public boolean intersects(Shape shape) {
        return shape.intersects((Rectangle) getBounds2D());
    }

    @Override
    public Shape getBounds2D() {
        return new Rectangle((int) x + 10, (int) y, 40, 50);
    }
}
