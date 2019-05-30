package de.bsinfo.game.pandarun.world;

import de.bsinfo.game.pandarun.gfx.ImageLoader;

import java.awt.image.BufferedImage;

class BackgroundImg {

    static BufferedImage backgroundImageOne, backgroundImageTwo;

    static void init(){
        backgroundImageOne = ImageLoader.loadImage("/textures/scaledBackground.png");
        backgroundImageTwo = ImageLoader.loadImage("/textures/scaledBackground.png");
    }
}
