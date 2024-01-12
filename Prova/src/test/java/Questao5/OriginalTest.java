package Questao5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OriginalTest {
    @Test
    void testMatarMutante1() {
        Original original = new Original();

        int valor = 400;
        String resultadoOriginal = original.converterParaRomano(valor);

        Mutante1 m1 = new Mutante1();
        assertEquals("CD", resultadoOriginal); // esse passa

        assertEquals("CD", m1.converterParaRomano(valor)); // mata o mutante
    }

    @Test
    void testMatarMutante2() {
        Original original = new Original();

        int valor = 1000;
        String resultadoOriginal = original.converterParaRomano(valor);

        Mutante2 m2 = new Mutante2();

        assertEquals("M", resultadoOriginal); // esse passa

        assertEquals("M", m2.converterParaRomano(valor)); // mata o mutante
    }

    @Test
    void testMatarMutante3() {
        Original original = new Original();

        int valor = 1000;
        String resultadoOriginal = original.converterParaRomano(valor);

        Mutante3 m3 = new Mutante3();

        assertEquals("M", resultadoOriginal); // esse passa

        assertEquals("M", m3.converterParaRomano(valor)); // esse também passa (não mata o mutante)

        /**
         * Os testes são equivalentes, pois o quando acontece
         * a subtração dentro do while o valor da variável num[i]
         * é sempre menor ou igual ao valor da variável número.
         * Dessa forma, o valor da variável número nunca é menor que zero.
         */
    }
}