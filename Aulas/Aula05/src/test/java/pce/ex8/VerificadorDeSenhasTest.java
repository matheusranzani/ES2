package pce.ex8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VerificadorDeSenhasTest {

    @ParameterizedTest
    @CsvSource({
            "BomDia",
            "olala",
            "abcdabcd3",
            "1234567890"
    })
    void testSenhaValida(String mySenhaValida) {
        Dicionario dicMock = mock(Dicionario.class);
        var senhasInvalidas = Arrays.asList("senha", "admin");

        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(senhasInvalidas);

        var ver = new VerificadorDeSenhas(dicMock);
        assertTrue(ver.validarNovaSenha(mySenhaValida));
    }

    @ParameterizedTest
    @CsvSource({
            "1234",
            "123456789012345",
            "#omDIa",
            "admin",
            "12345678901"
    })
    void testSenhaInvalida(String mySenhaInvalida) {
        Dicionario dicMock = mock(Dicionario.class);
        var senhasInvalidas = Arrays.asList("senha", "admin");

        when(dicMock.getListaDeSenhasInvalidas())
                .thenReturn(senhasInvalidas);

        var ver = new VerificadorDeSenhas(dicMock);
        assertFalse(ver.validarNovaSenha(mySenhaInvalida));
    }
}