package model;

import java.util.ArrayList;
import java.util.List;

import enuns.Turno;

public class Disciplina {
	private int codigo;
	private String nome;
	private String sigla;
	private Turno turno;
	private int num_aulas;
	private List<Faltas> faltas = new ArrayList<Faltas>();
	private List<Notas> notas = new ArrayList<Notas>();
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public int getNum_aulas() {
		return num_aulas;
	}
	public void setNum_aulas(int num_aulas) {
		this.num_aulas = num_aulas;
	}
	public List<Faltas> getFaltas() {
		return faltas;
	}
	public void setFaltas(List<Faltas> faltas) {
		this.faltas = faltas;
	}
	public List<Notas> getNotas() {
		return notas;
	}
	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}
	
}
