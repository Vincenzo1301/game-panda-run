package de.bsinfo.game.pandarun.gfx;

import java.awt.image.BufferedImage;

/**
 * The Assets class is responsible for loading the required sprites into a BufferedImage
 * or into arrays, that contains elements of the data type BufferedImage.
 */
public class Assets {

    private static final int ASSETS_WIDTH = 40;
    private static final int ASSETS_HEIGHT = 50;
    private static final int OBSTACLE_WIDTH = 100;

    public static BufferedImage[] playerRunArray;
    public static BufferedImage[] shurikenArray;
    public static BufferedImage playerJumping;
    public static BufferedImage stoneObject;
    public static BufferedImage trunkObject;
    public static BufferedImage[] campFire;

    public static int getAssetsHeight() {
        return ASSETS_HEIGHT;
    }

    /**
     * Initiation of the sprite sheets
     */
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/new-pixelart.png"));

        playerRunArray = new BufferedImage[3];
        playerRunArray[0] = sheet.crop(0, 0, ASSETS_WIDTH, ASSETS_HEIGHT);
        playerRunArray[1] = sheet.crop(ASSETS_WIDTH, 0, ASSETS_WIDTH, ASSETS_HEIGHT);
        playerRunArray[2] = sheet.crop(ASSETS_WIDTH * 2, 0, ASSETS_WIDTH, ASSETS_HEIGHT);

        playerJumping = sheet.crop(0, ASSETS_HEIGHT, ASSETS_WIDTH, ASSETS_HEIGHT);
        stoneObject = sheet.crop(0, ASSETS_HEIGHT * 2, OBSTACLE_WIDTH, ASSETS_HEIGHT);
        trunkObject = sheet.crop(0, ASSETS_HEIGHT * 4, 50, ASSETS_HEIGHT);

        shurikenArray = new BufferedImage[3];
        shurikenArray[0] = sheet.crop(0, ASSETS_HEIGHT * 3, ASSETS_WIDTH, ASSETS_HEIGHT);
        shurikenArray[1] = sheet.crop(ASSETS_WIDTH, ASSETS_HEIGHT * 3, ASSETS_WIDTH, ASSETS_HEIGHT);
        shurikenArray[2] = sheet.crop(ASSETS_WIDTH * 2, ASSETS_HEIGHT * 3, ASSETS_WIDTH, ASSETS_HEIGHT);

        campFire = new BufferedImage[2];
        campFire[0] = sheet.crop(0, ASSETS_HEIGHT * 5, 60, ASSETS_HEIGHT);
        campFire[1] = sheet.crop(60, ASSETS_HEIGHT * 5, 60, ASSETS_HEIGHT);
    }
}