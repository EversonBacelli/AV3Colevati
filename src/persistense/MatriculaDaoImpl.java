package persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enuns.Turno;
import model.Aluno;
import model.Disciplina;
import model.Matricula;

public class MatriculaDaoImpl implements MatriculaDao {

	@Override
	public List<Matricula> listAllMatriculas() {
		List<Matricula> matriculas = new ArrayList<Matricula>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "select a.ra_aluno, a.nome as nomeAluno, d.codigo, d.nome as nomeDisciplina,"
					+ " d.sigla, d.turno, d.num_aulas from tbl_matricula m inner join"
					+ " tbl_alunos a on m.ra_aluno = a.ra_aluno inner join"
					+ " tbl_disciplina d on d.codigo = m.codigo_disciplina";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Matricula m = new Matricula();
				
				//cria e verifica se aluno ja existe na lista
				Aluno a = new Aluno();
				a.setRa(rs.getInt("ra_aluno"));
				Aluno aVerificado = matriculas.size() != 0?verificaAluno(matriculas, a):null;
				if (aVerificado == null) {
					a.setNome(rs.getString("nomeAluno"));
				}else {
					a = aVerificado;
				}
				
				//cria e verifica se disciplina ja existe na lista
				Disciplina d = new Disciplina();
				d.setCodigo(rs.getInt("codigo"));
				Disciplina dVerificada = matriculas.size() != 0?verificaDisciplinas(matriculas, d):null;
				if (dVerificada == null) {
					d.setNome(rs.getString("nomeDisciplina"));
					d.setSigla(rs.getString("sigla"));
					String tipo = rs.getString("turno");
					d.setTurno(rs.getString("turno").equals("T") ? Turno.TARDE : Turno.NOITE);
					d.setNum_aulas(rs.getInt("num_aulas"));
				}else {
					d = dVerificada;
				}
				
				m.setAluno(a);
				m.setDisciplina(d);
				a.adicionarMatricula(m);
				d.adicionarMatricula(m);
				matriculas.add(m);
			}
		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matriculas;
	}

	public Aluno verificaAluno(List<Matricula> matriculas, Aluno a) {
		Aluno aluno = null;
		for (Matricula m : matriculas) {
			if (m.getAluno().getRa() == a.getRa()) {
				aluno = m.getAluno();
			}
		}
		return aluno;
	}

	public Disciplina verificaDisciplinas(List<Matricula> matriculas, Disciplina d) {
		Disciplina disciplina = null;
		for (Matricula m : matriculas) {
			if (m.getDisciplina().getCodigo() == d.getCodigo()) {
				disciplina = m.getDisciplina();
			}
		}
		return disciplina;
	}

	@Override
	public List<Matricula> listAllMatriculasByDisciplina(String disciplina, String sigla) {
		List<Matricula> matriculas = new ArrayList<Matricula>();
		try {
			Connection con = DBUtil.getInstance().getConnection();
			String sql = "select a.ra_aluno, a.nome as nomeAluno, d.codigo, d.nome as nomeDisciplina,"
					+ " d.sigla, d.turno, d.num_aulas from tbl_matricula m inner join"
					+ " tbl_alunos a on m.ra_aluno = a.ra_aluno inner join"
					+ " tbl_disciplina d on d.codigo = m.codigo_disciplina where d.nome = ? and d.sigla = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, disciplina);
			ps.setString(2, sigla);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Matricula m = new Matricula();
				
				//cria e verifica se aluno ja existe na lista
				Aluno a = new Aluno();
				a.setRa(rs.getInt("ra_aluno"));
				Aluno aVerificado = matriculas.size() != 0?verificaAluno(matriculas, a):null;
				if (aVerificado == null) {
					a.setNome(rs.getString("nomeAluno"));
				}else {
					a = aVerificado;
				}
				//cria e verifica se disciplina ja existe na lista
				Disciplina d = new Disciplina();
				if(matriculas.size() == 0){
					d.setCodigo(rs.getInt("codigo"));
					d.setNome(rs.getString("nomeDisciplina"));
					d.setSigla(rs.getString("sigla"));
					String tipo = rs.getString("turno");
					d.setTurno(rs.getString("turno").equals("T") ? Turno.TARDE : Turno.NOITE);
					d.setNum_aulas(rs.getInt("num_aulas"));
				}else {
					d = matriculas.get(matriculas.size()-1).getDisciplina();
				}
				m.setAluno(a);
				m.setDisciplina(d);
				a.adicionarMatricula(m);
				d.adicionarMatricula(m);
				matriculas.add(m);
			}
		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matriculas;
	}

}
