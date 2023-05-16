package tn.iit.projectjee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.projectjee.model.Model;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletContext();
		List<Model> lu = (List<Model>) application.getAttribute("tUser");

		int pos = Integer.parseInt(request.getParameter("pos"));
		Model user = lu.get(pos);
		HttpSession session = request.getSession();
		Model currentUser = (Model) session.getAttribute("currentUser");
		lu.remove(pos);
		application.setAttribute("tUser", lu);
		if (!currentUser.equals(user)) {
			response.sendRedirect("index.jsp");
		}
		else {
			session.invalidate();
			response.sendRedirect("auth.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
