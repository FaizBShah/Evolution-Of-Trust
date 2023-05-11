package org.example;

import java.security.SecureRandom;

public class TrustMatch {
    private static final int MIN_NUM_OF_ROUNDS = 5;
    private static final int MAX_NUM_OF_ROUNDS = 7;

    private final Player player1;
    private final Player player2;
    private final ScoreBoard scoreBoard;
    private int numberOfRounds;

    public TrustMatch(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreBoard = new ScoreBoard();
        this.numberOfRounds = new SecureRandom().nextInt(MAX_NUM_OF_ROUNDS - MIN_NUM_OF_ROUNDS + 1) + MIN_NUM_OF_ROUNDS;
    }

    public void start() {
        if (numberOfRounds <= 0) {
            throw new IllegalStateException("Match has been over");
        }

        while (numberOfRounds > 0) {
            TrustChoice playerOneTrustChoice = player1.play();
            TrustChoice playerTwoTrustChoice = player2.play();

            scoreBoard.update(playerOneTrustChoice, playerTwoTrustChoice);

            numberOfRounds--;
        }
    }

    public Player getWinner() {
        if (numberOfRounds > 0) {
            throw new IllegalStateException("Match has not started yet");
        }

        int winner = scoreBoard.getWinner();

        if (winner == 0) {
            return null;
        }

        return winner == 1 ? player1 : player2;
    }
}
