package de.bsinfo.game.pandarun.state;

public class StateHandler {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

}
