package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OriginalTest {
    @Test
    public void testMatarMutante1() {
        Original original = new Original();
        int[] vetor = {5, 4, 3, 2, 1};

        int resultadoOriginal = original.getMaior(vetor);
        assertEquals(5, resultadoOriginal); // esse passa

        Mutante1 m1 = new Mutante1();
        assertEquals(5, m1.getMaior(vetor)); // esse não passa (mata o mutante)
    }

    @Test
    public void testMatarMutante2() {
        Original original = new Original();
        int[] vetor = {4, 5, 3, 2, 1};

        int resultadoOriginal = original.getMaior(vetor);
        assertEquals(5, resultadoOriginal); // esse passa

        Mutante2 m2 = new Mutante2();
        assertEquals(5, m2.getMaior(vetor)); // esse não passa (mata o mutante)
    }

    @Test
    public void testMatarMutante3() {
        Original original = new Original();
        int[] vetor = {4, 5, 3, 2, 1};

        int resultadoOriginal = original.getMaior(vetor);
        assertEquals(5, resultadoOriginal); // esse passa

        Mutante3 m3 = new Mutante3();
        assertEquals(5, m3.getMaior(vetor)); // esse também passa (não mata o mutante)

        /**
         * Os testes são equivalentes, pois ambos percorrem todas
         * as posições do vetor e verificam qual é o maior valor
         * armazenado nele
         */
    }
}