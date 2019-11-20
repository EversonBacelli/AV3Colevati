package persistense;

import java.util.List;

import enuns.Turno;
import model.Notas;

public interface NotaDAO {
	void inserirNotas(Notas notas);
	List<Notas> visualizarNotas(int cod_disciplina);
	void atualizarNota(Notas nota);
	void delete(Notas nota);
}
