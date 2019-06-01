package de.bsinfo.game.pandarun.state;

import de.bsinfo.game.pandarun.model.Obstacle;
import de.bsinfo.game.pandarun.model.Player;
import de.bsinfo.game.pandarun.code.Game;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {

    private Player player;
    private World world;
    private Obstacle obstacle;

    private ArrayList<Obstacle> obstacleArrayList;

    public GameState(Game game) {
        super(game);

        world = new World(0, 0, 650, 0);
        obstacleArrayList = new ArrayList<>();
        obstacle = new Obstacle(650, World.getWorldGround() + 20);
        obstacleArrayList.add(obstacle);
        player = new Player(game, 50, World.getWorldGround());
    }

    private void generateObstacle() {
        if(obstacleArrayList.get(obstacleArrayList.size()-1).getX() == 350) {
            obstacleArrayList.add(new Obstacle(650, World.getWorldGround() + 20));
        }
    }

    private void removeObstacle() {
        if(obstacleArrayList.get(0).getX() == -1) {
            obstacleArrayList.remove(0);
        }
    }

    @Override
    public void update() {
        generateObstacle();
        player.update();
        world.update();
        for(Obstacle obstacle: obstacleArrayList) {
            obstacle.update();
        }
        removeObstacle();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        obstacle.render(g);
        player.render(g);
        for(Obstacle obstacle: obstacleArrayList) {
            obstacle.render(g);
        }
    }

}
