package controller;

import java.util.List;

import model.Faltas;
import persistense.FaltaDAO;
import persistense.FaltaDAOImpl;

public class PseudoControllerFaltas {

	public static void main(String[] args) {
		FaltaDAO fDao = new FaltaDAOImpl();
		fDao.deletarFaltas(3);
	}
	
	private static void atualizarFalta() {
		FaltaDAO fDao = new FaltaDAOImpl();
		Faltas faltas = new Faltas();
		faltas.setPresenca("F");
		fDao.atualizarFaltas(faltas);
	}
	private static void visualizarFaltas() {
		FaltaDAO fDao = new FaltaDAOImpl();

		List<Faltas> listaFaltas = fDao.visualizarFaltas(1);
		
		for(Faltas f: listaFaltas) {
		}
	}

	private static void InserirFaltas() {
		Faltas f = new Faltas();
		f.setPresenca("P");
		FaltaDAO fDao  = new FaltaDAOImpl();
		fDao.insetirFaltas(f);
		//visualizarNotas();
		//insertirNotas();
	}
}
