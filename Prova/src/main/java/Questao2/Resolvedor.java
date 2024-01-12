package Questao2;

import java.util.ArrayList;

public class Resolvedor {
    private ClienteRepo repo;
    public Resolvedor(ClienteRepo repo) {this.repo = repo;}

    public ArrayList<Cliente> definirPromocao(int[] cods) throws Exception {
        if (/*1*/cods == null || /*2*/cods.length == 0) {
            /*3*/throw new IllegalArgumentException("sem codigo");
        }

        /*4*/var clientes = new ArrayList<Cliente>();

        /*5*/for (int cod : cods) {
            /*6*/Cliente c = repo.getCliente(cod);

            if (/*7*/c == null) {
                /*8*/throw new Exception("Codigo do cliente invalido");
            }

            /*9*/clientes.add(c);
        }

        /*10*/var reposta = new ArrayList<Cliente>();

        if (/*11*/clientes.size() >= 3) {
            /*12*/for (Cliente c : clientes) {
                /*13*/c.setDesconto(20);
                /*14*/reposta.add(c);
            }
        } /*15*/else {
            /*16*/clientes.get(0).setDesconto(10);
            /*17*/reposta.add(clientes.get(0));
            if (/*18*/clientes.size() > 1) {
                /*19*/clientes.get(1).setDesconto(7);
                /*20*/reposta.add(clientes.get(1));
            }
        }

        /*21*/return reposta;
    }
}
