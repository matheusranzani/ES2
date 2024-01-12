package Questao2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ResolvedorTest {
    @Test
    void testClienteComListaDeCodigosNull() {
        ClienteRepo mockClienteRepo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(mockClienteRepo);

        Exception e = assertThrows(Exception.class, () -> resolvedor.definirPromocao(null));
        assertEquals("sem codigo", e.getMessage());
    }

    @Test
    void testClienteComListaDeCodigosVazia() {
        ClienteRepo mockClienteRepo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(mockClienteRepo);

        int[] codsFake = {};
        Exception e = assertThrows(Exception.class, () -> resolvedor.definirPromocao(codsFake));
        assertEquals("sem codigo", e.getMessage());
    }

    @Test
    void testClienteCodigoInvalido() {
        ClienteRepo mockClienteRepo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(mockClienteRepo);

        when(mockClienteRepo.getCliente(-1)).thenReturn(null);

        int[] codsFake = {-1};

        Exception e = assertThrows(Exception.class, () -> resolvedor.definirPromocao(codsFake));

        assertEquals("Codigo do cliente invalido", e.getMessage());
    }

    @Test
    void testTresOuMaisClientes() throws Exception {
        ClienteRepo mockClienteRepo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(mockClienteRepo);

        ArrayList<Cliente> clienteFake = new ArrayList<Cliente>();
        clienteFake.add(new Cliente(1, "Matheus"));
        clienteFake.add(new Cliente(2, "Gabriel"));
        clienteFake.add(new Cliente(3, "Thales"));

        when(mockClienteRepo.getCliente(1)).thenReturn(clienteFake.get(0));
        when(mockClienteRepo.getCliente(2)).thenReturn(clienteFake.get(1));
        when(mockClienteRepo.getCliente(3)).thenReturn(clienteFake.get(2));

        int[] codsFake = {1, 2, 3};

        ArrayList<Cliente> c = resolvedor.definirPromocao(codsFake);

        assertEquals(clienteFake, c);
    }

    @Test
    void testExatamenteUmCliente() throws Exception {
        ClienteRepo mockClienteRepo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(mockClienteRepo);

        ArrayList<Cliente> clienteFake = new ArrayList<Cliente>();
        clienteFake.add(new Cliente(1, "Matheus"));

        when(mockClienteRepo.getCliente(1)).thenReturn(clienteFake.get(0));

        int[] codsFake = {1};

        ArrayList<Cliente> c = resolvedor.definirPromocao(codsFake);

        assertEquals(clienteFake, c);
    }

    @Test
    void testDoisOuMaisClientes() throws Exception {
        ClienteRepo mockClienteRepo = mock(ClienteRepo.class);
        Resolvedor resolvedor = new Resolvedor(mockClienteRepo);

        ArrayList<Cliente> clienteFake = new ArrayList<Cliente>();
        clienteFake.add(new Cliente(1, "Matheus"));
        clienteFake.add(new Cliente(2, "Gabriel"));

        when(mockClienteRepo.getCliente(1)).thenReturn(clienteFake.get(0));
        when(mockClienteRepo.getCliente(2)).thenReturn(clienteFake.get(1));

        int[] codsFake = {1, 2};

        ArrayList<Cliente> c = resolvedor.definirPromocao(codsFake);

        assertEquals(clienteFake, c);
    }
}