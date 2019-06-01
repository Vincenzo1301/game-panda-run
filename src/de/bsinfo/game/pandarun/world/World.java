package de.bsinfo.game.pandarun.world;

import de.bsinfo.game.pandarun.model.Score;
import de.bsinfo.game.pandarun.gfx.Assets;

import java.awt.*;

public class World {

    // Sets the ground for the player and obstacle
    private static final int GROUND_Y = 285;
    private static int worldGround = GROUND_Y - Assets.getAssetsHeight();

    private double backgroundOneX, backgroundOneY, backgroundTwoX, backgroundTwoY;

    public World(double backgroundOneX, double backgroundOneY, double backgroundTwoX, double backgroundTwoY) {
        this.backgroundOneX = backgroundOneX;
        this.backgroundOneY = backgroundOneY;
        this.backgroundTwoX = backgroundTwoX;
        this.backgroundTwoY = backgroundTwoY;

        BackgroundImg.init();
    }

    public static int getWorldGround() {
        return worldGround;
    }

    public void update() {
        // Move the x position left for next time
        backgroundOneX -= Score.getGameSpeed();
        backgroundTwoX -= Score.getGameSpeed();

        // Check to see if the image has gone off stage left e.g. 600 * (-1) = -600
        if (backgroundOneX <= -1 * BackgroundImg.backgroundImageOne.getWidth()) {
            backgroundOneX = backgroundOneX + BackgroundImg.backgroundImageOne.getWidth() * 2;
        }
        if (backgroundTwoX <= -1 * BackgroundImg.backgroundImageTwo.getWidth()) {
            backgroundTwoX = backgroundTwoX + BackgroundImg.backgroundImageTwo.getWidth() * 2;
        }
    }

    /**
     * Draw the image onto the Graphics reference
     */
    public void render(Graphics g) {
        g.drawImage(BackgroundImg.backgroundImageOne, (int) backgroundOneX, (int) backgroundOneY, null);
        g.drawImage(BackgroundImg.backgroundImageTwo, (int) backgroundTwoX, (int) backgroundTwoY, null);
    }
}