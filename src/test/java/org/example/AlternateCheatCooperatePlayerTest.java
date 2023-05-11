package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternateCheatCooperatePlayerTest {

    @Test
    void shouldAlwaysCooperatePlayerObjectCreateSuccessfully() {
        assertDoesNotThrow(() -> new AlternateCheatCooperatePlayer());
    }

    @Test
    void shouldPlayFunctionReturnCooperateAlways() {
        Player player = new AlternateCheatCooperatePlayer();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                assertEquals(TrustChoice.COOPERATE, player.play());
            } else {
                assertEquals(TrustChoice.CHEAT, player.play());
            }
        }
    }

}