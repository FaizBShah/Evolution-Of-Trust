package org.example;

public class AlwaysCheatPlayerStrategy implements PlayerStrategy {
    @Override
    public TrustChoice play() {
        return TrustChoice.CHEAT;
    }
}
