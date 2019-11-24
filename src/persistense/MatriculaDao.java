package persistense;

import java.util.List;

import model.Matricula;

public interface MatriculaDao {
	List<Matricula> listAllMatriculas();
	List<Matricula> listAllMatriculasByDisciplina(String disciplina, String sigla);
}
