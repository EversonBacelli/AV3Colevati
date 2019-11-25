package controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.AlunosNotas;
import model.Disciplina;
import model.Matricula;
import persistense.DisciplinaDao;
import persistense.DisciplinaDaoImpl;
import persistense.MatriculaDao;
import persistense.MatriculaDaoImpl;

@WebServlet("/notas")
public class NotasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4434359422458120869L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =  req.getServletContext().getRequestDispatcher("/WEB-INF/notas.jsp");
		MatriculaDao mDao = new MatriculaDaoImpl();
		String cmd = req.getParameter("cmd");
		if(cmd != null && cmd.equals("Procurar")) {
			String valor = req.getParameter("materia");
			String disciplinaQuebrada[] = valor.split("-");
			List<Matricula> listaMatriculas = mDao.listAllMatriculasByDisciplina(disciplinaQuebrada[0], disciplinaQuebrada[1]);
			List<AlunosNotas> alunosNotas = getAlunosNotas(listaMatriculas);
			req.setAttribute("alunosNotas", alunosNotas);
		}
		List<Disciplina> disc = (List<Disciplina>) req.getAttribute("disciplinas");
		if(disc == null) {
			DisciplinaDao dDao = new DisciplinaDaoImpl();
			List<Disciplina> disciplinas = dDao.findAllForCombo();
			req.setAttribute("disciplinas", disciplinas);
		}
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = req.getParameter("finalArray");
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<AlunosNotas>>(){}.getType();
		List<AlunosNotas>listaAlunos = gson.fromJson(json, listType);
		doGet(req, resp);
	}
	
	public List<AlunosNotas> getAlunosNotas(List<Matricula> listaMatriculas){
		List<AlunosNotas> listaAlunoNotas = new ArrayList<AlunosNotas>();
		for(Matricula m : listaMatriculas) {
			AlunosNotas alunoNota = new AlunosNotas();
			alunoNota.setRa(m.getAluno().getRa());
			alunoNota.setIdDisciplina(m.getDisciplina().getCodigo());
			alunoNota.setAlunoNome(m.getAluno().getNome());
			listaAlunoNotas.add(alunoNota);
		}
		return listaAlunoNotas;
	}
}
