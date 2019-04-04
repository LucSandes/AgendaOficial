package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import service.AgendaService;

@WebServlet("/IncluirAgenda.do")
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		String pEndereco = request.getParameter("endereco");
		
		// instanciar o javabean
		Agenda agenda = new Agenda();
		agenda.setNome(pNome);
		agenda.setTelefone(pTelefone);
		agenda.setEmail(pEmail);
		agenda.setEndereco(pEndereco);
		
		// instanciar o service
		AgendaService as = new AgendaService();
		as.criar(agenda);
		agenda = as.carregar(agenda);
		
		//enviarpara o jsp
		request.setAttribute("agenda", agenda);
		RequestDispatcher view = request.getRequestDispatcher("AgendaResultado.jsp");
		view.forward(request, response);
		
	}
}
