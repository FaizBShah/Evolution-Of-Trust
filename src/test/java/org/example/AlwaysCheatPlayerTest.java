package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCheatPlayerTest {

    @Test
    void shouldAlwaysCooperatePlayerObjectCreateSuccessfully() {
        assertDoesNotThrow(() -> new AlwaysCheatPlayer());
    }

    @Test
    void shouldPlayFunctionReturnCooperateAlways() {
        Player player = new AlwaysCheatPlayer();

        for (int i = 0; i < 10; i++) {
            assertEquals(TrustChoice.CHEAT, player.play());
        }
    }

}