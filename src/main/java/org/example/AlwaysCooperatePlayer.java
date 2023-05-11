package org.example;

public class AlwaysCooperatePlayer extends Player {
    public AlwaysCooperatePlayer() {
        super(new AlwaysCooperatePlayerStrategy());
    }
}
