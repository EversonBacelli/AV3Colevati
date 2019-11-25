package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.AlunosNotas;

public class NotaDAOImpl implements NotaDAO {

	@Override
	public void inserirNotas(List<AlunosNotas> alunosNotas) {
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "insert into notas values(?,?,?,?)";
			for (AlunosNotas alunoNota : alunosNotas) {
				for (int i = 1; i <= 3; i++) {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, alunoNota.getRa());
					ps.setInt(2, alunoNota.getIdDisciplina());
					ps.setInt(3, i);
					switch (i) {
					case 1:
						ps.setInt(4, alunoNota.getNota1());
						break;
					case 2:
						ps.setInt(4, alunoNota.getNota2());
						break;
					case 3:
						ps.setInt(4, alunoNota.getNota3());
						break;
					}
					ps.execute();
					ps.close();
				}

			}
			con.close();
		} catch (DAOException |

				SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
