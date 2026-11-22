package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BunTest {
    @Test
    void returnsNameAndPriceGivenAtCreation() {
        Bun bun = new Bun("sesame", 12.5f);

        assertEquals("sesame", bun.getName());
        assertEquals(12.5f, bun.getPrice());
    }
}
