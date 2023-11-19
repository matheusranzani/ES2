package pce.ex12;

public class MontanhaRussaControlador {
    ClienteDao clienteDao;
    public MontanhaRussaControlador(ClienteDao pClienteDao) {
        clienteDao = pClienteDao;
    }

    public String autorizar(String nome, int idade) throws Exception {
        boolean contemEspaco = false;
        if (nome.contains(" ")) contemEspaco = true;

        boolean apenasLetras = true;
        if (contemEspaco) {
            for (char c : nome.toCharArray()) {
                if (Character.isLetter(c) || c == ' ') {
                    continue;
                } else {
                    apenasLetras = false;
                    break;
                }
            }
        }

        boolean nomeValido = false;
        if (contemEspaco && apenasLetras) nomeValido = true;

        if (nomeValido && idade >= 1 && idade <= 120) {
            if (idade >= 18 && idade <= 90) return "autorizado";
            if (idade < 18) return "acompanhado dos pais";
            if (idade > 90) return "acompanhado do responsavel legal";
        }

        throw new Exception("Nome ou idade inválidos");
    }
}
