package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlternateCheatCooperatePlayerStrategyTest {

    @Test
    void shouldAlwaysCooperatePlayerStrategyObjectGetCreatedSuccessFully() {
        assertDoesNotThrow(() -> new AlternateCheatCooperatePlayerStrategy());
    }

    @Test
    void shouldReturnCooperateWhenPlayIsCalled() {
        AlternateCheatCooperatePlayerStrategy strategy = new AlternateCheatCooperatePlayerStrategy();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                assertEquals(TrustChoice.COOPERATE, strategy.play());
            } else {
                assertEquals(TrustChoice.CHEAT, strategy.play());
            }
        }
    }

}