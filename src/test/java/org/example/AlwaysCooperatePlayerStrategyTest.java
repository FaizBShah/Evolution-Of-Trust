package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCooperatePlayerStrategyTest {

    @Test
    void shouldAlwaysCooperatePlayerStrategyObjectGetCreatedSuccessFully() {
        assertDoesNotThrow(() -> new AlwaysCooperatePlayerStrategy());
    }

    @Test
    void shouldReturnCooperateWhenPlayIsCalled() {
        AlwaysCooperatePlayerStrategy strategy = new AlwaysCooperatePlayerStrategy();

        for (int i = 0; i < 10; i++) {
            assertEquals(TrustChoice.COOPERATE, strategy.play());
        }
    }

}