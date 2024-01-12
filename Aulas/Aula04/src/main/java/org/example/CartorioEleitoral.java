// Link para planilha: https://docs.google.com/spreadsheets/d/13MXknBi1iWjnwTMYWPVpqueodrVFsfWAdHS8BKQo71E/edit#gid=0

package org.example;

public interface CartorioEleitoral {
    /**
     * Esse método pode retornar:
     * - "nao existe": se o cpf não possui
     * titulo associado
     * - "pendencia": o titulo possui
     * alguma pendencia
     * - "OK": situacao regularizada
     * para o título
     */

    public String verificar(String cpf);
}