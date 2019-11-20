package controller;

import java.util.List;

import model.Faltas;
import model.Notas;
import persistense.FaltaDAO;
import persistense.FaltaDAOImpl;
import persistense.NotaDAO;
import persistense.NotaDAOImpl;

public class PseudoControllerNotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}



	private static void deletarNota() {
		NotaDAO nDao = new NotaDAOImpl();
		Notas n = new Notas();
		n.setRa_aluno(3);
		nDao.delete(n);
	}



	private static void atualizarNotas() {
		NotaDAO nDao = new NotaDAOImpl();
		Notas n = new Notas();
		n.setRa_aluno(1);
		n.setNota(6.5);
		nDao.atualizarNota(n);
	}

	

	private static void visualizarNotas() {
		NotaDAO nota = new NotaDAOImpl();

		List<Notas> listaNotas = nota.visualizarNotas(1);
		
		for(Notas n: listaNotas) {
			System.out.println("RA: " + n.getRa_aluno() + " - nota " + n.getNota());
		}
	}

	private static void inserirNotas() {
		NotaDAO nota = new NotaDAOImpl();
		Notas n = new Notas();
		
		n.setRa_aluno(1);
		n.setCod_avaliacao(1);
		n.setCod_disciplina(1);
		n.setNota(9.5);
		nota.inserirNotas(n);
	}

}
