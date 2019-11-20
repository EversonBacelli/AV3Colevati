package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private int ra;
	private String nome;
	private List<Faltas> faltas = new ArrayList<Faltas>();
	private List<Notas> notas = new ArrayList<Notas>();
	
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
