// Link para planilha: https://docs.google.com/spreadsheets/d/13MXknBi1iWjnwTMYWPVpqueodrVFsfWAdHS8BKQo71E/edit#gid=0

package Questao3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VerificadorEleitoralTest {
    @Test
    void testConsultarSituacaoIdadeInvalida() {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        Exception exception = assertThrows(Exception.class, () -> {
            verificador.consultarSituacao(-1, "12345678901");
        });

        assertEquals("idade invalida", exception.getMessage());
    } /*1 e 2*/

    @Test
    void testConsultarSituacaoCPFInvalido() {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        Exception exception = assertThrows(Exception.class, () -> {
            verificador.consultarSituacao(25, "1234");
        }); /*3 e 4*/

        assertEquals("cpf invalido", exception.getMessage());
    }

    @Test
    void testConsultarSituacaoFacaUmTitulo() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        when(cartorioMock.verificar(anyString())).thenReturn("nao existe");

        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        String result = verificador.consultarSituacao(18, "12345678901");

        assertEquals("faca um titulo", result);
    } /*8 e 9*/

    @Test
    void testConsultarSituacaoRegularizeSeuTitulo() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        when(cartorioMock.verificar(anyString())).thenReturn("pendencia");

        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        String result = verificador.consultarSituacao(25, "12345678901");

        assertEquals("regularize seu titulo", result);
    } /*10 e 11*/

    @Test
    void testConsultarSituacaoVotoObrigatorio() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        when(cartorioMock.verificar(anyString())).thenReturn("OK");

        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        String result = verificador.consultarSituacao(18, "12345678901");

        assertEquals("voto obrigatorio", result);
    } /*13*/

    @Test
    void testConsultarSituacaoStatusDesconhecido() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        when(cartorioMock.verificar(anyString())).thenReturn("status_desconhecido");

        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        String result = verificador.consultarSituacao(25, "12345678901");

        assertEquals("erro desconhecido", result);
    } /*17*/

    @Test
    void testConsultarSituacaoVotoFacultativo() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        when(cartorioMock.verificar(anyString())).thenReturn("OK");

        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        String result = verificador.consultarSituacao(17, "12345678901");

        assertEquals("voto facultativo", result);
    } /*14 e 15*/

    @Test
    void testConsultarSituacaoIdadeMenorQue16() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);

        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        String result = verificador.consultarSituacao(15, "12345678901");

        assertEquals("nao pode votar", result);
    } /*6*/

    @Test
    void testConsultarSituacaoIdadeMaiorQue200() {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        Exception exception = assertThrows(Exception.class, () -> {
            verificador.consultarSituacao(201, "12345678901");
        });

        assertEquals("idade invalida", exception.getMessage());
    }

    @Test
    void testConsultarSituacaoCPFNull() {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        Exception exception = assertThrows(Exception.class, () -> {
            verificador.consultarSituacao(25, null);
        });

        assertEquals("cpf invalido", exception.getMessage());
    } /*4*/

    @Test
    void testConsultarSituacaoIdadeMaiorQue70() throws Exception {
        CartorioEleitoral cartorioMock = mock(CartorioEleitoral.class);
        VerificadorEleitoral verificador = new VerificadorEleitoral(cartorioMock);

        when(cartorioMock.verificar(anyString())).thenReturn("OK");

        String result = verificador.consultarSituacao(80, "12345678901");

        assertEquals("voto facultativo", result);
    } /*14*/
}