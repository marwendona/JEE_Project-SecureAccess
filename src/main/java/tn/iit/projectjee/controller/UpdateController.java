package tn.iit.projectjee.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tn.iit.projectjee.model.Model;

@WebServlet("/Update")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pos = Integer.parseInt(request.getParameter("pos"));
        List<Model> lu = (List<Model>) getServletContext().getAttribute("tUser");
        Model user = lu.get(pos);
        request.setAttribute("pos", pos);
        request.setAttribute("user", user);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pos = Integer.parseInt(request.getParameter("pos"));
        List<Model> lu = (List<Model>) getServletContext().getAttribute("tUser");
        Model user = new Model(request.getParameter("nom"),
                request.getParameter("prenom"), request.getParameter("login"), request.getParameter("pwd"));
        lu.set(pos, user);
        getServletContext().setAttribute("tUser", lu);
        response.sendRedirect("index.jsp");
    }
}