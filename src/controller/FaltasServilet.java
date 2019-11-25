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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.AlunosFaltas;
import model.AlunosNotas;
import model.Disciplina;
import model.Faltas;
import model.Matricula;
import persistense.DisciplinaDao;
import persistense.DisciplinaDaoImpl;
import persistense.FaltaDAO;
import persistense.FaltaDAOImpl;
import persistense.MatriculaDao;
import persistense.MatriculaDaoImpl;

@WebServlet("/faltas")
public class FaltasServilet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =  req.getServletContext().getRequestDispatcher("/WEB-INF/faltas.jsp");
		MatriculaDao mDao = new MatriculaDaoImpl();
		String cmd = req.getParameter("cmd");
		if(cmd != null && cmd.equals("BuscarTurma")) {
			String valor = req.getParameter("materia");
			String disciplinaQuebrada[] = valor.split("-");
			List<Matricula> listaMatriculas = mDao.listAllMatriculasByDisciplina(disciplinaQuebrada[0], disciplinaQuebrada[1]);
			List<AlunosFaltas> alunosFaltas = getAlunosFaltas(listaMatriculas);
			HttpSession session = req.getSession();
			session.setAttribute("alunosFaltas", alunosFaltas);
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
		System.out.println(json);
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<AlunosFaltas>>(){}.getType();
		List<AlunosFaltas> alunosDaFaltas  = gson.fromJson(json, listType);
		doGet(req, resp);
	}


	public List<AlunosFaltas> getAlunosFaltas(List<Matricula> listaMatriculas){
		List<AlunosFaltas> listaAlunosFaltas = new ArrayList<>();
		for(Matricula m : listaMatriculas) {
			AlunosFaltas alunosFaltas = new AlunosFaltas();
			alunosFaltas.setRa_aluno(m.getAluno().getRa());
			alunosFaltas.setNome_aluno(m.getAluno().getNome());
			listaAlunosFaltas.add(alunosFaltas);
		}
		return listaAlunosFaltas;
	}
	
	
	

}
