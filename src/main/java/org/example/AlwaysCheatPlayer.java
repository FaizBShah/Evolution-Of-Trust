package org.example;

public class AlwaysCheatPlayer extends Player {
    public AlwaysCheatPlayer() {
        super(new AlwaysCheatPlayerStrategy());
    }
}
