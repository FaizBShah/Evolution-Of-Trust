package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCooperatePlayerTest {

    @Test
    void shouldAlwaysCooperatePlayerObjectCreateSuccessfully() {
        assertDoesNotThrow(() -> new AlwaysCooperatePlayer());
    }

    @Test
    void shouldPlayFunctionReturnCooperateAlways() {
        Player player = new AlwaysCooperatePlayer();

        for (int i = 0; i < 10; i++) {
            assertEquals(TrustChoice.COOPERATE, player.play());
        }
    }

}