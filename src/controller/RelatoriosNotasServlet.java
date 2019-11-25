package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Disciplina;
import model.RelatorioNotas;
import persistense.DisciplinaDao;
import persistense.DisciplinaDaoImpl;
import persistense.RelatorioNotaDao;
import persistense.RelatorioNotaDaoImpl;

@WebServlet("/relatoriosNotas")
public class RelatoriosNotasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7538894630239077566L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =  req.getServletContext().getRequestDispatcher("/WEB-INF/relatoriosNota.jsp");
		DisciplinaDao dDao = new DisciplinaDaoImpl();
		List<Disciplina> disciplinas = dDao.findAllForCombo();
		req.setAttribute("disciplinas", disciplinas);
		String parameter = req.getParameter("cmd");
		if(parameter!=null && parameter.equals("Procurar")) {
			String id = req.getParameter("materia");
			List<RelatorioNotas> relatoriosNotas = new ArrayList<RelatorioNotas>();
			RelatorioNotaDao rDao = new RelatorioNotaDaoImpl();
			relatoriosNotas = rDao.findAll(Integer.parseInt(id));
			req.setAttribute("relatoriosNotas", relatoriosNotas);
		}
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
