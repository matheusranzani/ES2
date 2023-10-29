package ex04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RelatorioDeFuncionariosTest {
    @Test
    void testSemFuncionariosNoBanco() {
        FuncionarioDAO funcDaoMock = mock(FuncionarioDAO.class);
        ReceitaFederal rfMock = mock(ReceitaFederal.class);

        RelatorioDeFuncionarios rel = new RelatorioDeFuncionarios(funcDaoMock);

        rel.setRf(rfMock);

        ArrayList<Funcionario> fakeList = new ArrayList<>();
        when(funcDaoMock.getFuncionariosBy("Dev"))
                .thenReturn(fakeList);

        int resposta = rel.getFuncComCPFBloqueado("Dev");

        assertEquals(0, resposta);
    }

    @Test
    void testDoisFuncionariosTecnicoSemCPFBloqueado() {
        FuncionarioDAO funcDaoMock = mock(FuncionarioDAO.class);
        ReceitaFederal rfMock = mock(ReceitaFederal.class);

        RelatorioDeFuncionarios rel = new RelatorioDeFuncionarios(funcDaoMock);
        rel.setRf(rfMock);

        ArrayList<Funcionario> fakeList = new ArrayList<>();
        fakeList.add(new Funcionario(11, "João", "11122233344"));
        fakeList.add(new Funcionario(33, "Maria", "11122233355"));

        when(funcDaoMock.getFuncionariosBy("Tecnico"))
                .thenReturn(fakeList);

        when(rfMock.isCPFBloqueado("11122233344")).thenReturn(false);
        when(rfMock.isCPFBloqueado("11122233355")).thenReturn(false);

        int resposta = rel.getFuncComCPFBloqueado("Tecnico");

        assertEquals(0, resposta);
    }

    @Test
    void testUmFuncionarioAnalistaComCPFBloqueado() {
        FuncionarioDAO funcDaoMock = mock(FuncionarioDAO.class);
        ReceitaFederal rfMock = mock(ReceitaFederal.class);

        RelatorioDeFuncionarios rel = new RelatorioDeFuncionarios(funcDaoMock);
        rel.setRf(rfMock);

        ArrayList<Funcionario> fakeList = new ArrayList<>();
        fakeList.add(new Funcionario(15, "Carlos", "11122233366"));

        when(funcDaoMock.getFuncionariosBy("Analista"))
                .thenReturn(fakeList);

        when(rfMock.isCPFBloqueado("11122233366")).thenReturn(true);

        int resposta = rel.getFuncComCPFBloqueado("Analista");

        assertEquals(1, resposta);
    }

    @Test
    void testQuartoFuncionariosGerenteComDoisCPFsBloqueados() {
        FuncionarioDAO funcDaoMock = mock(FuncionarioDAO.class);
        ReceitaFederal rfMock = mock(ReceitaFederal.class);

        RelatorioDeFuncionarios rel = new RelatorioDeFuncionarios(funcDaoMock);
        rel.setRf(rfMock);

        ArrayList<Funcionario> fakeList = new ArrayList<>();
        fakeList.add(new Funcionario(20, "Arisa", "123456789-00"));
        fakeList.add(new Funcionario(21, "Thales", "111222333-44"));
        fakeList.add(new Funcionario(22, "Matheus", "654321987-23"));
        fakeList.add(new Funcionario(23, "Gabriel", "098876654-99"));

        when(funcDaoMock.getFuncionariosBy("Gerente"))
                .thenReturn(fakeList);

        when(rfMock.isCPFBloqueado("123456789-00")).thenReturn(false);
        when(rfMock.isCPFBloqueado("111222333-44")).thenReturn(true);
        when(rfMock.isCPFBloqueado("654321987-23")).thenReturn(false);
        when(rfMock.isCPFBloqueado("098876654-99")).thenReturn(true);

        int resposta = rel.getFuncComCPFBloqueado("Gerente");

        assertEquals(2, resposta);
    }
}
