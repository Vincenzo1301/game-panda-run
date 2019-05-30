package de.bsinfo.game.pandarun.gfx;

import de.bsinfo.game.pandarun.timer.Timer;

import java.awt.image.BufferedImage;

public class Animation {

    // Index of the current frame in the buffered image array
    private int index;

    // Specifies the speed at which the next element in the array is to be skipped
    private int speed;

    private Timer timer;

    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;

        timer = new Timer(0);
    }

    public void update() {
        timer.update( System.currentTimeMillis() - timer.getLastTime());
        timer.setLastTime(System.currentTimeMillis());

        if (timer.getTime() > speed) {
            index++;
            timer.setTime(0);
            if (index >= frames.length)
                index = 0;
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}