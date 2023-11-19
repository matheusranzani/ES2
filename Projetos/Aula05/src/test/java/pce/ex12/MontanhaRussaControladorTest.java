package pce.ex12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pce.ex8.VerificadorDeSenhas;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MontanhaRussaControladorTest {
    @ParameterizedTest
    @CsvSource({
            "Matheus Ranzani",
            "Taylor Swift",
            "Pérola Vasco",
            "João Pedro de Azevedo"
    })
    public void testAutorizarClienteValido(String meuClienteValido) throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente(meuClienteValido))
                .thenReturn(true);

        var controlador = new MontanhaRussaControlador(clienteDaoMock);

        String resultado = controlador.autorizar(meuClienteValido, 22);

        assertEquals("autorizado", resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "João!",
            "Maria_Julia",
            "André",
            "123 456 789"
    })
    public void testRecusarNaoCliente(String nomeInvalido) {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        when(clienteDaoMock.ehCliente(nomeInvalido))
                .thenReturn(false);

        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

        assertThrows(Exception.class, () -> controlador.autorizar(nomeInvalido, 40));
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "125",
            "-5",
            "200",
    })
    public void testRecusarClienteComIdadeInvalida(int idadeInvalida) {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

        assertThrows(Exception.class, () -> controlador.autorizar("Ana Maria", idadeInvalida));
    }

    @ParameterizedTest
    @CsvSource({
            "10",
            "15",
            "17",
            "3"
    })
    public void testAutorizarClienteAcompanhadoDosPais(int idadeValida) throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

        String resultado = controlador.autorizar("Maria Clara", idadeValida);

        assertEquals("acompanhado dos pais", resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "91",
            "100",
            "120",
            "95",
    })
    public void testAutorizarClienteComResponsavelLegal(int idadeValida) throws Exception {
        ClienteDao clienteDaoMock = mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDaoMock);

        String resultado = controlador.autorizar("Antonio Carlos", idadeValida);

        assertEquals("acompanhado do responsavel legal", resultado);
    }
}