package tn.iit.projectjee.dao;

import java.sql.SQLException;

import tn.iit.projectjee.model.Model;
import tn.iit.projectjee.utils.JDBCUTIL;

public class UtilisateurDao {
    public static void save(Model user) {
        String query = "insert into utilisateur values(0,'" + user.getNom() + "','" + user.getPrenom() + "','" + user.getLogin() + "','" + user.getPwd() + "')";
        System.out.println(query);
        try {
            JDBCUTIL.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void delete(Model user) {
    }

    public static Model getByLoginPwd(String login, String pwd) {
        return null;
    }
}