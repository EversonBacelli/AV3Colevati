package persistense;

import java.util.List;

import enuns.Turno;
import model.Faltas;

public interface FaltaDAO {
	void insetirFaltas(Faltas faltas);
	List<Faltas> visualizarFaltas(int ra_aluno);
	void atualizarFaltas(Faltas faltas);
	void deletarFaltas(int ra_aluno);
}
