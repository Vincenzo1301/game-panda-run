package de.bsinfo.game.pandarun.world;

import de.bsinfo.game.pandarun.gfx.Assets;

import java.awt.*;

public class World {

    // Sets the ground for the player and obstacle
    private static final int GROUND_Y = 285;
    private static int worldGround = GROUND_Y - Assets.getAssetsHeight();

    private double backgroundOneFirstLayerX, backgroundOneSecondlayerX, backgroundTwoFirstLayerX, backGroundTwoSecondLayerX, backgroundY;

    public World(double backgroundOneFirstLayerX, double backgroundOneSecondlayerX, double backgroundTwoFirstLayerX,
                 double backGroundTwoSecondLayerX, double backgroundY) {
        this.backgroundOneFirstLayerX = backgroundOneFirstLayerX;
        this.backgroundOneSecondlayerX = backgroundOneSecondlayerX;
        this.backgroundTwoFirstLayerX = backgroundTwoFirstLayerX;
        this.backGroundTwoSecondLayerX = backGroundTwoSecondLayerX;
        this.backgroundY = backgroundY;

        BackgroundImg.init();
    }

    public static int getWorldGround() {
        return worldGround;
    }

    public void update() {
        // Move the x position left for next time
        backgroundOneFirstLayerX -= 4;
        backgroundTwoFirstLayerX -= 4;

        backgroundOneSecondlayerX -= 2;
        backGroundTwoSecondLayerX -= 2;

        // Check to see if the image has gone off stage left e.g. 600 * (-1) = -600
        if (backgroundOneFirstLayerX <= -1 * BackgroundImg.backgroundImageOneFirstLayer.getWidth()) {
            backgroundOneFirstLayerX = backgroundOneFirstLayerX + BackgroundImg.backgroundImageOneFirstLayer.getWidth() * 2;
        }
        if (backgroundTwoFirstLayerX <= -1 * BackgroundImg.backgroundImageTwoFirstLayer.getWidth()) {
            backgroundTwoFirstLayerX = backgroundTwoFirstLayerX + BackgroundImg.backgroundImageTwoFirstLayer.getWidth() * 2;
        }

        if (backgroundOneSecondlayerX <= -1 * BackgroundImg.backgroundImageOneSecondLayer.getWidth()) {
            backgroundOneSecondlayerX = backgroundOneSecondlayerX + BackgroundImg.backgroundImageOneSecondLayer.getWidth() * 2;
        }
        if (backGroundTwoSecondLayerX <= -1 * BackgroundImg.backgroundImageTwoSecondLayer.getWidth()) {
            backGroundTwoSecondLayerX = backGroundTwoSecondLayerX + BackgroundImg.backgroundImageTwoSecondLayer.getWidth() * 2;
        }
    }

    /**
     * Draw the image onto the Graphics reference
     */
    public void render(Graphics g) {
        g.drawImage(BackgroundImg.backgroundImageOneSecondLayer, (int) backgroundOneSecondlayerX, (int) backgroundY, null);
        g.drawImage(BackgroundImg.backgroundImageTwoSecondLayer, (int) backGroundTwoSecondLayerX, (int) backgroundY, null);

        g.drawImage(BackgroundImg.backgroundImageOneFirstLayer, (int) backgroundOneFirstLayerX, (int) backgroundY, null);
        g.drawImage(BackgroundImg.backgroundImageTwoFirstLayer, (int) backgroundTwoFirstLayerX, (int) backgroundY, null);
    }
}