package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enuns.Turno;
import model.Faltas;
import model.Notas;

public class FaltaDAOImpl implements FaltaDAO {

	@Override
	public void insetirFaltas(Faltas falta) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "INSERT INTO tbl_faltas"
					+ " (ra_aluno, cod_disciplina, data, presenca)"
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt          (1, falta.getRa_aluno());
			stmt.setInt          (2, falta.getCod_disciplina());
			stmt.setString       (3,  falta.getData());
			stmt.setString       (4,  falta.getPresenca());
			stmt.executeUpdate();
			con.close();
			System.out.println("Falta Inserida com sucesso");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<Faltas> visualizarFaltas(int ra_aluno) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			List<Faltas> listaFaltas = new ArrayList<>();
			String sql = "select * from tbl_faltas";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Faltas faltas = new Faltas();
				faltas.setRa_aluno(rs.getInt("ra_aluno"));
				faltas.setCod_disciplina(rs.getInt("cod_disciplina"));
				faltas.setData(rs.getString("data"));
				faltas.setPresenca(rs.getString("presenca"));
				listaFaltas.add(faltas);
			}
			ps.close();
			rs.close();
			return listaFaltas;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizarFaltas(Faltas faltas) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "UPDATE tbl_faltas set presenca = '" + faltas.getPresenca() 
					+ "' where ra_aluno = " + faltas.getRa_aluno();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			con.close();
			stmt.close();
			System.out.println("Atualizado com sucesso");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletarFaltas(int ra_aluno) {
		// TODO Auto-generated method stub
		Connection con;
		try {
			con = DBUtil.getInstance().getConnection();
			String sql = "DELETE from tbl_faltas " 
			+ "where ra_aluno = " + ra_aluno;
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			con.close();
			stmt.close();
			System.out.println("Deletado com sucesso");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
