package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/relatoriosFalta")
public class RelatoriosFaltasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7923737405558294833L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =  req.getServletContext().getRequestDispatcher("/WEB-INF/relatoriosFalta.jsp");
		dispatcher.forward(req, resp);
	}

}
