package tn.iit.projectjee.vue;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Inscription() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\r\n"
                + "<html>\r\n"
                + "<head>\r\n"
                + "<meta charset=\"ISO-8859-1\">\r\n"
                + "<title>ServletForm</title>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "\r\n"
                + "<form action=\"InscriptionController\" method=\"post\">\r\n"
                + "		\r\n"
                + "		<div>Nom :<input name=\"nom\">\r\n"
                + "		</div>\r\n"
                + "		<div>Prenom :<input name=\"prenom\">\r\n"
                + "		</div>\r\n"
                + "		<div>Login :<input name=\"login\">\r\n"
                + "		</div>\r\n"
                + "		<div>Mot De Passe :\r\n"
                + "		<input name=\"mp\" type=\"password\"></div>\r\n"
                + "	\r\n"
                + "		<div><button type=\"submit\">submit</button></div>\r\n"
                + "	</form>\r\n"
                + "	</body>\r\n"
                + "</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}