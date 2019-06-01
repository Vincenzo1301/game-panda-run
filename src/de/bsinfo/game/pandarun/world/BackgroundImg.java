package de.bsinfo.game.pandarun.world;

import de.bsinfo.game.pandarun.gfx.ImageLoader;

import java.awt.image.BufferedImage;

class BackgroundImg {

    static BufferedImage backgroundImageOneFirstLayer, backgroundImageTwoFirstLayer, backgroundImageTwoSecondLayer, backgroundImageOneSecondLayer;

    static void init(){
        backgroundImageOneFirstLayer = ImageLoader.loadImage("/textures/backgroundFirstLayer.png");
        backgroundImageTwoFirstLayer = ImageLoader.loadImage("/textures/backgroundFirstLayer.png");

        backgroundImageOneSecondLayer = ImageLoader.loadImage("/textures/DarkerbackgroundSecondLayer.png");
        backgroundImageTwoSecondLayer = ImageLoader.loadImage("/textures/DarkerbackgroundSecondLayer.png");

    }
}
