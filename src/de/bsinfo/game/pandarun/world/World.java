package de.bsinfo.game.pandarun.world;

import de.bsinfo.game.pandarun.gfx.Assets;

import java.awt.*;

public class World {

    // Sets the ground for the player and obstacle
    private static final int GROUND_Y = 285;
    private static int groundForPlayersAndObjects = GROUND_Y - Assets.getAssetsHeight();

    private int backgroundOneX, backgroundOneY, backgroundTwoX, backgroundTwoY;

    public World(int backgroundOneX, int backgroundOneY, int backgroundTwoX, int backgroundTwoY) {
        this.backgroundOneX = backgroundOneX;
        this.backgroundOneY = backgroundOneY;
        this.backgroundTwoX = backgroundTwoX;
        this.backgroundTwoY = backgroundTwoY;

        BackgroundImg.init();
    }

    public static int getGroundForPlayersAndObjects() {
        return groundForPlayersAndObjects;
    }

    public static int getGameSpeed() {
        return 2;
    }

    public void update() {
        // Move the x position left for next time
        backgroundOneX -= getGameSpeed();
        backgroundTwoX -= getGameSpeed();

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
        g.drawImage(BackgroundImg.backgroundImageOne, backgroundOneX, backgroundOneY, null);
        g.drawImage(BackgroundImg.backgroundImageTwo, backgroundTwoX, backgroundTwoY, null);
    }
}