package org.example;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PessoaDAOTest {
    RHService rhServiceMock;
    @BeforeEach
    void setupMock() {
        // Criando um objeto que "mocka" o comportamento da interface/classe
        rhServiceMock = mock(RHService.class);

        var fakeList = new ArrayList<Pessoa>();
        fakeList.add(new Pessoa(1, 45, "Kate Perry"));
        fakeList.add(new Pessoa(2, 77, "Chuck Norris"));
        fakeList.add(new Pessoa(3, 36, "Avril Lavigne"));

        // Simular o comportamento do mock
        when(rhServiceMock.getAllPessoas())
                .thenReturn(fakeList);
    }

    @ParameterizedTest
    @CsvSource({
            "Chuck Norris, true",
            "Noel, false",
            "Kate Perry, true",
            "avril LAVIGNE, true"
    })
    void testExistePessoa(String nomeDaPessoaProcurada, boolean saidaEsperda) {
        PessoaDAO pessoaDAO = new PessoaDAO(rhServiceMock);

        assertEquals(saidaEsperda, pessoaDAO.existePessoa(nomeDaPessoaProcurada));
    }

    /* @org.junit.jupiter.api.Test
    void testExistePessoaProcurada() {
        PessoaDAO pessoaDAO = new PessoaDAO(rhServiceMock);

        assertTrue(pessoaDAO.existePessoa("Chuck Norris"));
    }

    @org.junit.jupiter.api.Test
    void testNaoExistePessoaProcurada() {
        PessoaDAO pessoaDAO = new PessoaDAO(rhServiceMock);

        assertFalse(pessoaDAO.existePessoa("Noel Galagher"));
    } */
}