package de.bsinfo.game.pandarun.model;

import java.awt.*;

public class Score extends GameObject {

    private long score;
    private int scoreRepeater = 0;
    private static double gameSpeed = 2;
    private boolean isOver = false;

    public Score(float x, float y, long score) {
        super(x, y);
        this.score = score;
    }

    private void scoreRepeaterCap() {
        if (scoreRepeater == 150) {
            scoreRepeater = 0;
            isOver = true;
        }
    }

    private void overLimit() {
        if (isOver) {
            gameSpeed += 0.2;
            isOver = false;
            if (gameSpeed >= 5) {
                gameSpeed = 5;
            }
        }
    }

    public void update() {
        score++;
        scoreRepeater++;
        scoreRepeaterCap();
        overLimit();
    }

    public void render(Graphics g) {
        int fontSize = 15;
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.WHITE);
        Font font = new Font("Monospaced", Font.BOLD, fontSize);
        graphics2D.setFont(font);
        graphics2D.drawString(String.valueOf(score), (int) x, (int) y);

    }

    // Returns the gameSpeed to change the values of world and objects
    public static double getGameSpeed() {
        return gameSpeed;
    }
}
