package org.example;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testGerarNumeroAleatorio() {
        Utils utils = new Utils();

        var res = utils.gerarNumeroAleatorio(1, 10);

        // assertTrue(res >= 1 && res <= 10);
        assertFalse(res < 1 || res > 10);
    }

    @org.junit.jupiter.api.Test
    void testGerarNumeroAleatorioIntInferiorNegativo() {
        Utils utils = new Utils();

        var res = utils.gerarNumeroAleatorio(-10, 10);

        assertEquals(-1, res);
    }

    @org.junit.jupiter.api.Test
    void testGerarNumeroAleatorioIntSuperiorNegativo() {
        Utils utils = new Utils();

        var res = utils.gerarNumeroAleatorio(1, -10);

        assertEquals(-1, res);
    }

    @org.junit.jupiter.api.Test
    void testAcharCaracterComprimentoCadeiaInvalido() {
        Utils utils = new Utils();

        char cadeia[] = {'t', 'e', 's', 't', 'e'};

        var res = utils.acharCaracter(25, cadeia, 's');

        assertEquals("comprimento invalido", res);
    }

    @org.junit.jupiter.api.Test
    void testAcharCaracterComprimentoCadeiaDiferente() {
        Utils utils = new Utils();

        char cadeia[] = {'t', 'e', 's', 't', 'e'};

        var res = utils.acharCaracter(6, cadeia, 's');

        assertEquals("comprimento fornecido diferente do comprimento real", res);
    }

    @org.junit.jupiter.api.Test
    void testAcharCaracter() {
        Utils utils = new Utils();

        char cadeia[] = {'t', 'e', 's', 't', 'e'};

        var res = utils.acharCaracter(5, cadeia, 's');

        assertEquals("2", res);
    }

    @org.junit.jupiter.api.Test
    void testAcharCaracterNaoEncontrado() {
        Utils utils = new Utils();

        char cadeia[] = {'t', 'e', 's', 't', 'e'};

        var res = utils.acharCaracter(5, cadeia, 'x');

        assertEquals("caractere não encontrado", res);
    }
}