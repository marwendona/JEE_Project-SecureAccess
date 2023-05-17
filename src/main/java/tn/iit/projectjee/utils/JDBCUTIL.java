package tn.iit.projectjee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUTIL {
    private static Statement stmt;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection ctx = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbgestuser", "root", "root123");
            stmt = ctx.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement() {
        return stmt;
    }
}