// Link da tabela: https://docs.google.com/spreadsheets/d/1QxsazGQPvlrfZ0p7pUzYESxW2urSm1SjYwY01Ri5brU/edit#gid=0

package Questao4;

public class Usuario {
    private int numeroDeSeguidores;
    boolean inativoPor2Semanas;
    boolean viuAnuncioUltimaHora;

    public Usuario(int numeroDeSeguidores, boolean inativoPor2Semanas, boolean viuAnuncioUltimaHora) {
        this.numeroDeSeguidores = numeroDeSeguidores;
        this.inativoPor2Semanas = inativoPor2Semanas;
        this.viuAnuncioUltimaHora = viuAnuncioUltimaHora;
    }

    public int getNumeroDeSeguidores() {
        return numeroDeSeguidores;
    }

    public boolean isInativoPor2Semanas() {
        return inativoPor2Semanas;
    }

    public boolean isViuAnuncioUltimaHora() {
        return viuAnuncioUltimaHora;
    }
}
