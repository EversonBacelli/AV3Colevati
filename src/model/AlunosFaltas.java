package model;

public class AlunosFaltas {
	int         ra_aluno;
	String      nome_aluno;
	String      presenca_aluno;
	String      id_disciplina;
	
	
	public String getId_disciplina() {
		return id_disciplina;
	}
	public void setId_disciplina(String id_disciplina) {
		this.id_disciplina = id_disciplina;
	}
	public int getRa_aluno() {
		return ra_aluno;
	}
	public void setRa_aluno(int ra_aluno) {
		this.ra_aluno = ra_aluno;
	}
	public String getNome_aluno() {
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}
	public String getPresenca_aluno() {
		return presenca_aluno;
	}
	public void setPresenca_aluno(String presenca_aluno) {
		this.presenca_aluno = presenca_aluno;
	}
}
