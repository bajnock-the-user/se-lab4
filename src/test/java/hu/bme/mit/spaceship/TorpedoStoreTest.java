package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void getTorpedoCount_InitialState() {
        // Arrange & Act
        TorpedoStore store = new TorpedoStore(10);

        // Assert
        assertEquals(10, store.getTorpedoCount());
    }

    @Test
    void isEmpty_WhenCountIsZero_ReturnsTrue() {
        // Arrange & Act
        TorpedoStore store = new TorpedoStore(0);

        // Assert
        assertTrue(store.isEmpty());
    }

    @Test
    void isEmpty_WhenCountIsGreaterThanZero_ReturnsFalse() {
        // Arrange & Act
        TorpedoStore store = new TorpedoStore(5);

        // Assert
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_WhenEmpty_ThrowsException() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test
    void fire_FailureRateAlwaysFails() {
        // Arrange: 100% failure rate
        TorpedoStore store = new TorpedoStore(5, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertFalse(result);
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void fire_InvalidArgument_ThrowsException() {
        // Arrange
        TorpedoStore store = new TorpedoStore(10);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
    }
    
}
