package de.bsinfo.game.pandarun;

import de.bsinfo.game.pandarun.code.Game;

/**
 * Launcher class
 *
 * Date: 06.05.2019
 * Authors: Kevin Zagar & Vincenzo Auricchio
 */
public class Launcher {
    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }
}