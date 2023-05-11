package org.example;

public abstract class Player {
    private PlayerStrategy playerStrategy;

    public Player(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    public TrustChoice play() {
        return playerStrategy.play();
    }
}
