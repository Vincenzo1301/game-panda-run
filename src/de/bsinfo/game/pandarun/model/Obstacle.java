package de.bsinfo.game.pandarun.model;

import de.bsinfo.game.pandarun.gfx.Animation;
import de.bsinfo.game.pandarun.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Obstacle extends GameObject {

    private BufferedImage bufferedImage;

    private Animation animationFly;
    private Animation animationCampFire;

    private boolean isShurriken;
    private boolean isCampFire;


    public Obstacle(float x, float y) {
        super(x, y);
        generateRandomBufferedImage();

    }

    private void generateRandomBufferedImage() {
        Random random = new Random();
        final int randomNumber = random.nextInt(4);
        if (randomNumber == 0) {
            bufferedImage = Assets.stoneObject;
        } else if (randomNumber == 1) {
            bufferedImage = Assets.trunkObject;
            y -= 20;
        } else if (randomNumber == 2) {
            isShurriken = true;
            animationFly = new Animation(200, Assets.shurikenArray);
            y -= 80;
        } else {
            isCampFire = true;
            animationCampFire = new Animation(200, Assets.campFire);
            y -= 20;
        }
    }

    @Override
    public void update() {
        if (isShurriken) {
            animationFly.update();
            x -= Score.getGameSpeed() + 0.5;
        } else if (isCampFire) {
            animationCampFire.update();
        }
        x -= Score.getGameSpeed();
    }

    @Override
    public void render(Graphics g) {
        if (!isShurriken && !isCampFire) {
            g.drawImage(bufferedImage, (int) x, (int) y, null);
        } else if (isCampFire) {
            g.drawImage(animationCampFire.getCurrentFrame(), (int) x, (int) y, null);
        } else {
            g.drawImage(animationFly.getCurrentFrame(), (int) x, (int) y, null);
        }
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
