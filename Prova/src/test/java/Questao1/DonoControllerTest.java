package Questao1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DonoControllerTest {
    @Test
    void testException() throws Exception {
        StringValidador mockStringValidador = mock(StringValidador.class);

        when(mockStringValidador.validarSobrenome("Ripper123")).thenReturn("erro");

        VisitasDAO visitasDAO = mock(VisitasDAO.class);
        DonoDAO donoDAO = mock(DonoDAO.class);

        DonoController donoController = new DonoController(mockStringValidador, visitasDAO, donoDAO);

        Exception exception = assertThrows(Exception.class, () -> {
            donoController.processarFormBusca("Ripper123");
        });

        assertEquals("erro", exception.getMessage());
    }

    @Test
    void testDonoNaoEncontradoPeloSobrenome() throws Exception {
        StringValidador mockStringValidador = mock(StringValidador.class);

        when(mockStringValidador.validarSobrenome("Silva")).thenReturn(null);

        VisitasDAO visitasDAO = mock(VisitasDAO.class);
        DonoDAO mockDonoDAO = mock(DonoDAO.class);

        List<Dono> lista = new ArrayList<>();
        when(mockDonoDAO.findBySobrenome("Silva")).thenReturn(lista);

        DonoController donoController = new DonoController(mockStringValidador, visitasDAO, mockDonoDAO);

        Pagina resultado = donoController.processarFormBusca("Silva");

        Pagina esperado = new Pagina("donos/encontrar", "ERRO: nao encontrado");

        assertInstanceOf(Pagina.class, resultado);
        assertEquals(esperado.getEndereco(), resultado.getEndereco());
        assertEquals(esperado.getDados(), resultado.getDados());
    }

    @Test
    void testUmDonoEncontradoPeloSobrenome() throws Exception {
        StringValidador mockStringValidador = mock(StringValidador.class);

        when(mockStringValidador.validarSobrenome("Silva")).thenReturn(null);

        VisitasDAO visitasDAO = mock(VisitasDAO.class);
        DonoDAO mockDonoDAO = mock(DonoDAO.class);

        List<Dono> lista = new ArrayList<>();
        lista.add(new Dono(1, "Silva"));
        when(mockDonoDAO.findBySobrenome("Silva")).thenReturn(lista);

        when(visitasDAO.incrementarVisitasPara("donos/1")).thenReturn(1);

        DonoController donoController = new DonoController(mockStringValidador, visitasDAO, mockDonoDAO);

        Pagina resultado = donoController.processarFormBusca("Silva");

        Pagina esperado = new Pagina("donos/1", 1);

        assertInstanceOf(Pagina.class, resultado);
        assertEquals(esperado.getEndereco(), resultado.getEndereco());
        assertEquals(esperado.getDados(), resultado.getDados());
    }

    @Test
    void testMaisDeUmDonoEncontradoPeloSobrenome() throws Exception {
        StringValidador mockStringValidador = mock(StringValidador.class);

        when(mockStringValidador.validarSobrenome("Silva")).thenReturn(null);

        VisitasDAO visitasDAO = mock(VisitasDAO.class);
        DonoDAO mockDonoDAO = mock(DonoDAO.class);

        List<Dono> lista = new ArrayList<>();
        lista.add(new Dono(1, "Silva"));
        lista.add(new Dono(2, "Silva"));
        when(mockDonoDAO.findBySobrenome("Silva")).thenReturn(lista);

        when(visitasDAO.incrementarVisitasPara("donos/listar")).thenReturn(2);

        DonoController donoController = new DonoController(mockStringValidador, visitasDAO, mockDonoDAO);

        Pagina resultado = donoController.processarFormBusca("Silva");

        Pagina esperado = new Pagina("donos/listar", 2);

        assertInstanceOf(Pagina.class, resultado);
        assertEquals(esperado.getEndereco(), resultado.getEndereco());
        assertEquals(esperado.getDados(), resultado.getDados());
    }
}