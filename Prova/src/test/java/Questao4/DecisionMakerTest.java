// Link da tabela: https://docs.google.com/spreadsheets/d/1QxsazGQPvlrfZ0p7pUzYESxW2urSm1SjYwY01Ri5brU/edit#gid=0

package Questao4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecisionMakerTest {
    @Test
    void testUsuarioInativoPorDuasSemanas() {
        DecisionMaker decisionMaker = new DecisionMaker();

        Usuario usuarioFake = new Usuario(100, true, false);

        boolean resultado = decisionMaker.mostrarAnuncio(usuarioFake, true);

        assertFalse(resultado);
    }

    @Test
    void testUsuarioAtivoQueViuAnuncioNaUltimaHora() {
        DecisionMaker decisionMaker = new DecisionMaker();

        Usuario usuarioFake = new Usuario(50, false, true);

        boolean resultado = decisionMaker.mostrarAnuncio(usuarioFake, false);

        assertFalse(resultado);
    }

    @Test
    void testUsuarioAtivoQueNaoViuAnuncioNaUltimaHoraQueTemMenosDe1001Seguidores() {
        DecisionMaker decisionMaker = new DecisionMaker();

        Usuario usuarioFake = new Usuario(780, false, false);

        boolean resultado = decisionMaker.mostrarAnuncio(usuarioFake, false);

        assertTrue(resultado);
    }

    @Test
    void testUsuarioAtivoQueNaoViuAnuncioNaUltimaHoraQueTemMaisDe1000SeguidoresEAnuncioRelevante() {
        DecisionMaker decisionMaker = new DecisionMaker();

        Usuario usuarioFake = new Usuario(2000, false, false);

        boolean resultado = decisionMaker.mostrarAnuncio(usuarioFake, true);

        assertTrue(resultado);
    }

    @Test
    void testUsuarioAtivoQueNaoViuAnuncioNaUltimaHoraQueTemMaisDe1000SeguidoresEAnuncioNaoRelevante() {
        DecisionMaker decisionMaker = new DecisionMaker();

        Usuario usuarioFake = new Usuario(2000, false, false);

        boolean resultado = decisionMaker.mostrarAnuncio(usuarioFake, false);

        assertFalse(resultado);
    }
}