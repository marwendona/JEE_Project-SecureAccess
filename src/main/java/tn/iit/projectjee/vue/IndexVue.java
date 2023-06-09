package tn.iit.projectjee.vue;

import tn.iit.projectjee.model.Model;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/IndexVue")
public class IndexVue extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexVue() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session1 = request.getSession(); // 2 sessions houni w authController (personnel)
        if (session1.getAttribute("currentUser") == null) {
            response.sendRedirect("AuthView");
        } else {
            Model user = (Model) session1.getAttribute("currentUser");
            PrintWriter out = response.getWriter();
            out.println("<p align=\"right\"><a href=\"Disconnect\">Déconnexion</a></p>");
            out.append("bienvenu");
            ServletContext application = getServletContext();
            List<Model> lu = (List<Model>) application.getAttribute("tUser");
            if (lu == null) {
                out.append("<br>Aucun utilisateur n'est inscrit !!!");
            }
            int pos = 0;
            out.append("<TABLE BORDER=1 ALIGN=CENTER>\n" + "<TH>nom<TH>prenom<TH>login<TH>action");
            for (Model u : lu) {
                out.println("<TR><TD>" + u.getNom());
                out.println("<TD>" + u.getPrenom());
                out.println("<TD>" + u.getLogin());
                out.println("<TD> <button onclick='window.location.href=\"Update?pos=" + pos
                        + "\"'>modifier</button>" + "<button onclick='window.location.href=\"Delete?pos="
                        + pos + "\"'>supprimer</button>");
                pos++;
            }
            out.println("</TABLE>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}