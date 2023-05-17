package tn.iit.projectjee.controller;

import tn.iit.projectjee.dao.UtilisateurDao;
import tn.iit.projectjee.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/InscriptionController")
public class InscriptionController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rdAuth = getServletContext().getRequestDispatcher("/auth.jsp");
//		String nom = request.getParameter("nom");
//		String prenom = request.getParameter("prenom");
//		String login = request.getParameter("login");
//		String mp = request.getParameter("pwd");
        HttpSession session = request.getSession();
        Model u = (Model) session.getAttribute("user");
        UtilisateurDao.save(u);
        ServletContext application = getServletContext();// 2 context houni w authController(partagé)
        ArrayList<Model> tUser = (ArrayList<Model>) application.getAttribute("tUser");
        if (tUser == null) { // pour le premier appel
            tUser = new ArrayList<>();
        }
        tUser.add(u);
        application.setAttribute("tUser", tUser); // cle valeur
        rdAuth.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}