package Questao1;

import java.util.List;

public interface DonoDAO {
    public List<Dono> findBySobrenome(String sobrenome);
}
