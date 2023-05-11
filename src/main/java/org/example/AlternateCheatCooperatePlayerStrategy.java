package org.example;

public class AlternateCheatCooperatePlayerStrategy implements PlayerStrategy {
    private int turn;

    public AlternateCheatCooperatePlayerStrategy() {
        this.turn = 0;
    }

    @Override
    public TrustChoice play() {
        return turn++ % 2 == 0 ? TrustChoice.COOPERATE : TrustChoice.CHEAT;
    }
}
