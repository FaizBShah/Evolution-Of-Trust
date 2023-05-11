package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    @Test
    void shouldScoreBoardObjectGetCreatedSuccessfully() {
        assertDoesNotThrow(() -> new ScoreBoard());
        assertEquals(0, new ScoreBoard().getWinner());
    }

    @Test
    void shouldUpdateScoreBoardProperlyIfBothPlayersCheat() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.CHEAT, TrustChoice.CHEAT);

        assertEquals(0, scoreBoard.getWinner());
    }

    @Test
    void shouldUpdateScoreBoardProperlyIfOnlyPlayerOneCheats() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.CHEAT, TrustChoice.COOPERATE);

        assertEquals(1, scoreBoard.getWinner());
    }

    @Test
    void shouldUpdateScoreBoardProperlyIfOnlyPlayerTwoCheats() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.COOPERATE, TrustChoice.CHEAT);

        assertEquals(2, scoreBoard.getWinner());
    }

    @Test
    void shouldUpdateScoreBoardProperlyIfBothPlayerCooperates() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.COOPERATE, TrustChoice.COOPERATE);

        assertEquals(0, scoreBoard.getWinner());
    }

    @Test
    void shouldReturnOneIfPlayerOneWins() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.CHEAT, TrustChoice.COOPERATE);

        assertEquals(1, scoreBoard.getWinner());
    }

    @Test
    void shouldReturnTwoIfPlayerTwoWins() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.COOPERATE, TrustChoice.CHEAT);

        assertEquals(2, scoreBoard.getWinner());
    }

    @Test
    void shouldReturnZeroIfBothPlayersHaveEqualScores() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.update(TrustChoice.COOPERATE, TrustChoice.COOPERATE);

        assertEquals(0, scoreBoard.getWinner());
    }

}