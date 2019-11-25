package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RelatorioNotas;

public class RelatorioNotaDaoImpl implements RelatorioNotaDao{

	@Override
	public List<RelatorioNotas> findAll(int id) {
		List<RelatorioNotas> relatorioNotas = new ArrayList<>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "select * from dbo.fn_relatorio_notas(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(id, 1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RelatorioNotas r = new RelatorioNotas();
				r.setRa_aluno(rs.getInt("ra_aluno"));
				r.setNome_aluno(rs.getString("nome_aluno"));
				r.setNota1(rs.getInt("nota1"));
				r.setNota2(rs.getInt("nota3"));
				r.setNota3(rs.getInt("nota3"));
				r.setMedia_final(rs.getDouble("media_final"));
				r.setSituacao(rs.getString("situacao"));
				relatorioNotas.add(r);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relatorioNotas;
	}

}
