package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCheatPlayerStrategyTest {

    @Test
    void shouldAlwaysCooperatePlayerStrategyObjectGetCreatedSuccessFully() {
        assertDoesNotThrow(() -> new AlwaysCheatPlayerStrategy());
    }

    @Test
    void shouldReturnCooperateWhenPlayIsCalled() {
        AlwaysCheatPlayerStrategy strategy = new AlwaysCheatPlayerStrategy();

        for (int i = 0; i < 10; i++) {
            assertEquals(TrustChoice.CHEAT, strategy.play());
        }
    }

}