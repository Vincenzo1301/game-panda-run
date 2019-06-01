package de.bsinfo.game.pandarun.state;

import de.bsinfo.game.pandarun.model.Score;
import de.bsinfo.game.pandarun.model.Obstacles;
import de.bsinfo.game.pandarun.model.Player;
import de.bsinfo.game.pandarun.code.Game;
import de.bsinfo.game.pandarun.world.World;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private World world;
    private Obstacles obstacle;
    private Score score;

    public GameState(Game game) {
        super(game);

        world = new World(0, 0, 650, 0);
        obstacle = new Obstacles(550, World.getWorldGround() + 20);
        player = new Player(game, 50, World.getWorldGround());
        score = new Score(580, 40, 0);
    }

    @Override
    public void update() {
        player.update();
        world.update();
        obstacle.update();
        score.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        obstacle.render(g);
        player.render(g);
        score.render(g);
    }


  /*  // Sets the ground for the player and obstacle
    private static final int GROUND_Y = 285;
    private static int groundForPlayersAndObjects = GROUND_Y - Assets.getAssetsHeight();*/

   /* public static int getWorldGround() {
        return groundForPlayersAndObjects;
    }

    // Sets the game paste
    public static int getGameSpeed() {
        return 2;
    }*/
}
