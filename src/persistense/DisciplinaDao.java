package persistense;

import java.util.List;

import model.Disciplina;

public interface DisciplinaDao {
	List<Disciplina> findAllForCombo();
}
