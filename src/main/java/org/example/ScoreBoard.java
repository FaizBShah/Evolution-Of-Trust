package org.example;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    public static final int REWARD_FOR_CHEATING = 3;
    public static final int REWARD_FOR_COOPERATING = 2;
    private int playerOneScore;
    private int playerTwoScore;

    private final Map<Map.Entry<TrustChoice, TrustChoice>, Runnable> scoreMap = new HashMap<>() {{
        put(new AbstractMap.SimpleImmutableEntry<>(
                TrustChoice.CHEAT,
                TrustChoice.CHEAT
        ), () -> {});
        put(new AbstractMap.SimpleImmutableEntry<>(
                TrustChoice.CHEAT,
                TrustChoice.COOPERATE
        ), () -> {
            playerOneScore += REWARD_FOR_CHEATING;
            playerTwoScore--;
        });
        put(new AbstractMap.SimpleImmutableEntry<>(
                TrustChoice.COOPERATE,
                TrustChoice.CHEAT
        ), () -> {
            playerOneScore--;
            playerTwoScore += REWARD_FOR_CHEATING;
        });
        put(new AbstractMap.SimpleImmutableEntry<>(
                TrustChoice.COOPERATE,
                TrustChoice.COOPERATE
        ), () -> {
            playerOneScore += REWARD_FOR_COOPERATING;
            playerTwoScore += REWARD_FOR_COOPERATING;
        });
    }};

    public ScoreBoard() {
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
    }

    public void update(TrustChoice playerOneTrustChoice, TrustChoice playerTwoTrustChoice) {
        scoreMap.get(new AbstractMap.SimpleImmutableEntry<>(
                playerOneTrustChoice,
                playerTwoTrustChoice
        )).run();
    }

    public int getWinner() {
        return playerOneScore > playerTwoScore ? 1 : playerOneScore < playerTwoScore ? 2 : 0;
    }
}
