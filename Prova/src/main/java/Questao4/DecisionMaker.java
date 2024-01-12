// Link da tabela: https://docs.google.com/spreadsheets/d/1QxsazGQPvlrfZ0p7pUzYESxW2urSm1SjYwY01Ri5brU/edit#gid=0

package Questao4;

public class DecisionMaker {
    public boolean mostrarAnuncio(Usuario u, boolean anuncioRelevante) {
        if (u.inativoPor2Semanas) {
            return false;
        } else {
            if (u.viuAnuncioUltimaHora) {
                return false;
            } else {
                if (u.getNumeroDeSeguidores() <= 1000) {
                    return true;
                } else {
                    if (anuncioRelevante) {
                        return true;
                    }
                }
            }
        }

       return false;
    }
}
