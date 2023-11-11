package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    // 1, 2, 4, 5, 6, 4, 7, 9
    @Test
    void testZero() throws Exception {
        var calc = new Calculadora();
        var res = calc.somatoriaLimitada(0, 500);

        assertEquals(0, res);
    }

    @Test
    void testException() {
        var calc = new Calculadora();

        assertThrows(Exception.class, () -> {
            calc.somatoriaLimitada(10, 10);
        });
    }

    @Test
    void testNegativeNumber() throws Exception {
        var calc = new Calculadora();
        var res = calc.somatoriaLimitada(-1, 500);

        assertEquals(1, res);
    }
}