package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enuns.Turno;
import model.Notas;

public class NotaDAOImpl implements NotaDAO{

	@Override
	public void inserirNotas(Notas notas) {
		
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "INSERT INTO tbl_notas"
					+ " (ra_aluno, cod_disciplina, cod_avalicacao, nota)"
					+ " VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt          (1, notas.getRa_aluno());
			stmt.setInt          (2, notas.getCod_disciplina());
			stmt.setInt          (3,  notas.getCod_avaliacao());
			stmt.setDouble       (4,  notas.getNota());
			stmt.executeUpdate();
			con.close();
			stmt.close();
			System.out.println("Nota inserida com sucesso");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<Notas> visualizarNotas(int cod_disciplina) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			List<Notas> listaNotas = new ArrayList<>();
			String sql = "select * from tbl_notas";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Notas notas = new Notas();
				notas.setRa_aluno(rs.getInt("ra_aluno"));
				notas.setCod_disciplina(rs.getInt("cod_disciplina"));
				notas.setCod_avaliacao(rs.getInt("cod_avalicacao"));
				notas.setNota(rs.getDouble("nota"));
				listaNotas.add(notas);
			}
			ps.close();
			rs.close();
			return listaNotas;
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
	public void atualizarNota(Notas nota) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "UPDATE tbl_notas set nota = " + nota.getNota() 
					+ "where ra_aluno = " + nota.getRa_aluno();
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
	public void delete(Notas nota) {
		// TODO Auto-generated method stub
		Connection con;
		try {
			con = DBUtil.getInstance().getConnection();
			String sql = "DELETE from tbl_notas " 
			+ "where ra_aluno = " + nota.getRa_aluno();
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
