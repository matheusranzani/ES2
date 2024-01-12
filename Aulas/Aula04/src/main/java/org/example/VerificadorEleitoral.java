// Link para planilha: https://docs.google.com/spreadsheets/d/13MXknBi1iWjnwTMYWPVpqueodrVFsfWAdHS8BKQo71E/edit#gid=0

package org.example;

public class VerificadorEleitoral {
    private CartorioEleitoral cartorioEleitoral;

    public VerificadorEleitoral(CartorioEleitoral cartorioEleitoral) {
        this.cartorioEleitoral = cartorioEleitoral;
    }

    public String consultarSituacao(int idade, String cpf) throws Exception {
        /*1*/if (idade < 0 || idade > 200)
            /*2*/throw new Exception("idade invalida");
        /*3*/if (cpf == null || cpf.length() != 11)
            /*4*/throw new Exception("cpf invalido");
        /*5*/if (idade < 16)
            /*6*/return "nao pode votar";

        /*7*/String status = cartorioEleitoral.verificar(cpf);

        /*8*/if (status.equals("nao existe"))
            /*9*/return "faca um titulo";
        /*10*/else if (status.equals("pendencia"))
            /*11*/return "regularize seu titulo";
        /*12*/else if (status.equals("OK")) {
            /*13*/String ret = "voto obrigatorio";
        /*14*/if (idade <= 17 || idade > 70)
            /*15*/ret = "voto facultativo";
        /*16*/return ret;
        }
        /*18*/return "erro desconhecido";
    }
}