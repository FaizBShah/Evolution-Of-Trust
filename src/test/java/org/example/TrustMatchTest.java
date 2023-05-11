package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrustMatchTest {

    @Test
    void shouldTestMatchObjectBeCreatedSuccessfully() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCooperatePlayer();

        assertDoesNotThrow(() -> new TrustMatch(player1, player2));
    }

    @Test
    void shouldStartWorkCorrectly() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCheatPlayer();

        TrustMatch match = new TrustMatch(player1, player2);

        assertDoesNotThrow(() -> match.start());

        assertEquals(player2, match.getWinner());
    }

    @Test
    void shouldThrowErrorIfTryingToStartAMatchAfterItHasAlreadyEnded() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCheatPlayer();

        TrustMatch match = new TrustMatch(player1, player2);

        match.start();
        match.getWinner();

        Throwable exception = assertThrows(IllegalStateException.class, () -> match.start());

        assertEquals("Match has been over", exception.getMessage());
    }

    @Test
    void shouldGetWinnerWorkCorrectly() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCooperatePlayer();

        TrustMatch match = new TrustMatch(player1, player2);

        match.start();

        assertNull(match.getWinner());
    }

    @Test
    void shouldThrowAnErrorIfTryingToGetWinnerOfTheMatchEvenBeforeTheMatchEnded() {
        Player player1 = new AlwaysCooperatePlayer();
        Player player2 = new AlwaysCooperatePlayer();

        TrustMatch match = new TrustMatch(player1, player2);

        Throwable exception = assertThrows(IllegalStateException.class, () -> match.getWinner());

        assertEquals("Match has not started yet", exception.getMessage());
    }

}