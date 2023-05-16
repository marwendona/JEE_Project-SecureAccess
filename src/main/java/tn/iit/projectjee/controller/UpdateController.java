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

import tn.iit.projectjee.model.Model;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext application = getServletContext();
		List<Model> lu = (List<Model>) application.getAttribute("tUser");
		
		int pos = Integer.parseInt(request.getParameter("pos"));
		Model user = lu.get(pos);
		response.setContentType("text/html");
		out.append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<form method=\"post\" action=\"Update\">\r\n"
				+"<input type=\"hidden\" name=\"pos\" value=\""+pos+"\">"
				+ "	Nom  : <input name=\"nom\" value=\""+user.getNom()+"\">\r\n"
				+ "	<br>Prénom  : <input name=\"prenom\" value=\""+user.getPrenom()+"\">\r\n"
				+ "	<br>Login  : <input name=\"login\" value=\""+user.getLogin()+"\">\r\n"
				+ "	<br>Mot de passe  : <input type=\"password\" name=\"pwd\" value=\""+user.getPwd()+"\">\r\n"
				+ "	<br><input type=\"submit\" value=\"Valider\">\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		List<Model> lu = (List<Model>) application.getAttribute("tUser");
		
		int pos = Integer.parseInt(request.getParameter("pos"));
		Model user = new Model(request.getParameter("nom"),
				request.getParameter("prenom"), request.getParameter("login")
				, request.getParameter("pwd"));
		lu.set(pos, user);
		application.setAttribute("tUser", lu);
		response.sendRedirect("index.jsp");
	}

}
