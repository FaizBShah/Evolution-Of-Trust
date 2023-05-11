package org.example;

public class AlwaysCooperatePlayerStrategy implements PlayerStrategy {
    @Override
    public TrustChoice play() {
        return TrustChoice.COOPERATE;
    }
}
