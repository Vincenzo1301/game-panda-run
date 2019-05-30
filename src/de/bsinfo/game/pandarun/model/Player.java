package de.bsinfo.game.pandarun.model;

import de.bsinfo.game.pandarun.code.Game;
import de.bsinfo.game.pandarun.gfx.Animation;
import de.bsinfo.game.pandarun.gfx.Assets;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;

public class Player extends GameObject {

    // Saves the game instance in which the player is located
    private Game game;

    private Animation animationRun;

    // Handle jumping and falling
    private boolean canJump = true;
    private boolean isJumping = false;
    private float maxSpeed;
    private double gravity;

    private int jumpForce;
    private boolean isFalling = false;
    private boolean inAir = false;


    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;

        gravity = 1;
        maxSpeed = 18;
        jumpForce = 18;


        // Animation
        animationRun = new Animation(100, Assets.playerRunArray);
    }

    private void input() {
        if ((game.getKeyManager().isJumping()) && (canJump)) {
            jumping();
            canJump = false;
            isJumping = true;
            inAir = true;
        }
    }

    private void jumping() {
        if (isJumping){
            y -= jumpForce;
            jumpForce --;
            if (0 == jumpForce){
                isFalling = true;
                isJumping = false;

            }
        }
    }

    private void falling(){
        if(isFalling){
            y += gravity;
            gravity ++;
        }
    }

    private void goesOfWhenPlayerGetsOnTheGround(){
        if (y >= World.getGroundForPlayersAndObjects()){
            y = World.getGroundForPlayersAndObjects();

            // Next jump reset
            jumpForce = 18;
            gravity = 1;
            isFalling = false;
            inAir = false;
            canJump = true;
        }
    }

        public void update () {
            // Animation
            animationRun.update();

            falling();
            goesOfWhenPlayerGetsOnTheGround();
            jumping();
            input();
        }

        public void render (Graphics g){
        if (inAir){
            g.drawImage(Assets.playerJumping, (int) x, (int) y, null);
        }else {
            g.drawImage(animationRun.getCurrentFrame(), (int) x, (int) y, null);
        }

    }
}



