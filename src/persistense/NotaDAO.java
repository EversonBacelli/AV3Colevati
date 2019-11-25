package persistense;

import java.util.List;

import model.AlunosNotas;

public interface NotaDAO {
	void inserirNotas(List<AlunosNotas> alunosNotas);
}
