package tn.iit.projectjee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.projectjee.model.Model;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rdAuth = getServletContext().getRequestDispatcher("/auth.jsp");
		RequestDispatcher rdIndex = getServletContext().getRequestDispatcher("/index.jsp");
		String login = request.getParameter("login");
		String mp = request.getParameter("pwd");
		HttpSession session = request.getSession(); // 2 sessions houni w index (personnel)
		ServletContext application = getServletContext();// 2 context houni w inscriController(partagé)
		ArrayList<Model> tUser = (ArrayList<Model>) application.getAttribute("tUser");
		boolean userFound = false;
		if (tUser == null) {
			request.setAttribute("erreur", "Aucun utilisateur n'est inscrit");
			rdAuth.forward(request, response);
		} else {
			for (Model u : tUser) {
				if ( u.getLogin().equals(login)  && u.getPwd().equals(mp)) {
					session.setAttribute("currentUser", u); // session fiha cle valeur
					userFound = true;
					break;
				}
			}
			if (userFound) {
				rdIndex.forward(request, response);
			} else {
				request.setAttribute("erreur", "Veuillez Verifer vos parametres !!!");
				rdAuth.forward(request, response);
			}

		}
	}
}

/*
 * if("admin".equals(login)&&"123".equals(mp)) { rdIndex.forward(request,
 * response); } else { request.setAttribute("erreur", "veuiller verifier !!");
 * rdAuth.forward(request, response); }
 * 
 * }
 * 
 * }
 */
