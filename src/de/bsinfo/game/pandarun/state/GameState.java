package de.bsinfo.game.pandarun.state;

import de.bsinfo.game.pandarun.gfx.Assets;
import de.bsinfo.game.pandarun.model.Obstacle;
import de.bsinfo.game.pandarun.model.Score;
import de.bsinfo.game.pandarun.model.Player;
import de.bsinfo.game.pandarun.code.Game;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {

    private Player player;
    private World world;
    private Obstacle obstacle;
    private Score score;
    private ArrayList<Obstacle> obstacleArrayList;

    public GameState(Game game) {
        super(game);

        world = new World(0, 0, 650, 0);

        obstacleArrayList = new ArrayList<>();
        obstacle = new Obstacle(650, World.getWorldGround() + 20);
        obstacleArrayList.add(obstacle);

        player = new Player(game, 50, World.getWorldGround());
        score = new Score(580, 40, 0);
    }

    private void generateObstacle() {
        if (obstacleArrayList.get(obstacleArrayList.size() - 1).getX() <= 350) {
            obstacleArrayList.add(new Obstacle(650, World.getWorldGround() + 20));
        }
    }

    private void removeObstacle() {
        if (obstacleArrayList.get(0).getX() == -1 + Assets.stoneObject.getWidth()) {
            obstacleArrayList.remove(0);
        }
    }

    @Override
    public void update() {
        player.update();
        world.update();
        removeObstacle();
        generateObstacle();
        for (Obstacle obstacle : obstacleArrayList) {
            obstacle.update();
            if (player.intersects(obstacle.getBounds2D())) {
                System.out.println("Spiel vorbei");
            }
        }
        score.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        for (Obstacle obstacle : obstacleArrayList) {
            obstacle.render(g);
        }
        player.render(g);
        score.render(g);
    }
}
