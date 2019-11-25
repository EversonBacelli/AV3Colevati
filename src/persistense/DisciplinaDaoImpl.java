package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;
import model.Faltas;

public class DisciplinaDaoImpl implements DisciplinaDao{
	@Override
	public List<Disciplina> findAllForCombo() {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			List<Disciplina> listaDisciplina = new ArrayList<>();
			String sql = "select * from tbl_disciplina";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Disciplina d = new Disciplina();
				d.setCodigo(rs.getInt("codigo"));
				d.setNome(rs.getString("nome"));
				d.setSigla(rs.getString("sigla"));
				listaDisciplina.add(d);
			}
			ps.close();
			rs.close();
			return listaDisciplina;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
