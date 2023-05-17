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

@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AuthController() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rdAuth = getServletContext().getRequestDispatcher("/auth.jsp");
        RequestDispatcher rdIndex = getServletContext().getRequestDispatcher("/index.jsp");
        String login = request.getParameter("login");
        String mp = request.getParameter("pwd");
        HttpSession session = request.getSession();
        ServletContext application = getServletContext();
        ArrayList<Model> tUser = (ArrayList<Model>) application.getAttribute("tUser");
        boolean userFound = false;
        if (tUser == null) {
            request.setAttribute("erreur", "Aucun utilisateur n'est inscrit");
            request.setAttribute("erreurStyle", "alert alert-danger");
            rdAuth.forward(request, response);
        } else {
            for (Model u : tUser) {
                if (u.getLogin().equals(login) && u.getPwd().equals(mp)) {
                    session.setAttribute("currentUser", u);
                    userFound = true;
                    break;
                }
            }
            if (userFound) {
                rdIndex.forward(request, response);
            } else {
                request.setAttribute("erreur", "Veuillez Verifer vos parametres !!!");
                request.setAttribute("erreurStyle", "alert alert-danger");
                rdAuth.forward(request, response);
            }
        }
    }
}