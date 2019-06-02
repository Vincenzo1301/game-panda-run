package de.bsinfo.game.pandarun.model;

import de.bsinfo.game.pandarun.code.Game;
import de.bsinfo.game.pandarun.gfx.Animation;
import de.bsinfo.game.pandarun.gfx.Assets;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;

public class Player extends GameObject {

    private static final int INIT_JUMP_FORCE = 18;
    private static final int INIT_GRAVITY = 1;

    // Saves the game instance in which the player is located
    private Game game;

    // The animation is responsible for loading the required BufferedImage resource for the player object
    private Animation animationRun;

    // Handling jumping and falling
    private boolean isAbleToJump = true;
    private boolean isJumping = false;
    private float maxSpeed;
    private double gravity;
    private int jumpForce;
    private boolean isFalling = false;
    private boolean inAir = false;

    public Player(Game game, float x, float y) {
        super(x, y);
        this.game = game;

        animationRun = new Animation(100, Assets.playerRunArray);

        gravity = INIT_GRAVITY;
        maxSpeed = INIT_JUMP_FORCE;
        jumpForce = INIT_JUMP_FORCE;
    }

    private void initJump() {
        if ((game.getKeyManager().isJumping()) && (isAbleToJump)) {
            jumping();
            isAbleToJump = false;
            isJumping = true;
            inAir = true;
        }
    }

    private void jumping() {
        if (isJumping) {
            y -= jumpForce;
            jumpForce--;
            if (0 == jumpForce) {
                isFalling = true;
                isJumping = false;

            }
        }
    }

    private void falling() {
        if (isFalling) {
            y += gravity;
            gravity++;
        }
    }

    private void resetJump() {
        y = World.getWorldGround();

        // Next jump reset
        jumpForce = INIT_JUMP_FORCE;
        gravity = 1;
        isFalling = false;
        inAir = false;
        isAbleToJump = true;
    }

    public void update() {
        animationRun.update();

        falling();
        jumping();

        if (y >= World.getWorldGround()) {
            resetJump();
        }
        initJump();
    }

    public void render(Graphics g) {
        if (inAir) {
            g.drawImage(Assets.playerJumping, (int) x, (int) y, null);
        } else {
            g.drawImage(animationRun.getCurrentFrame(), (int) x, (int) y, null);
        }
    }

    @Override
    public boolean intersects(Shape shape) {
        return shape.intersects((Rectangle)getBounds2D());
    }

    @Override
    public Shape getBounds2D() {
        return new Rectangle((int) x, (int) y, 21, 21);
    }
}