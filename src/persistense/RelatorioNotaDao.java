package persistense;

import java.util.List;

import model.RelatorioNotas;

public interface RelatorioNotaDao {
	List<RelatorioNotas> findAll(int id);
}
