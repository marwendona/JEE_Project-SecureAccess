package tn.iit.projectjee.vue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthView
 */
@WebServlet("/AuthView")
public class AuthView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		out.println( "	<p align=\"right\">	<a href=\"Inscription\">inscription</a></p>");

		String erreurMessage = (String) request.getAttribute("erreur");
		if (erreurMessage != null) {
			out.print(erreurMessage);
		}
		out.println("<form action=\"AuthController\" method=\"post\">\r\n"
				+ "		login:<input name=\"login\"><br>mot de passe:<input name=\"pwd\"> "
				+ "<button type=\"submit\">valider</button>\r\n" + "	</form>\r\n" + "</body>\r\n" + "</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
