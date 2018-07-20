package com.ex.dao;

import com.ex.sql.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private static SQLConnection connectionUtil = SQLConnection.getConnectionUtil();

    public static boolean login(String username, String password, String user) {
        Boolean loginStatus = false;

        if (user == "") {
            user = "employee";
        }

        try (Connection conn = connectionUtil.getConnection()) {

            String query = "Select username, password From " + user + " WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String passwordSQL = resultSet.getString("password");

                if (passwordSQL.equals(password)) {
                    loginStatus = true;

                }
            }

//            System.out.println(username);
//            System.out.println(password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loginStatus;

//        if(password.equals("admin123")){
//            out.print("Welcome, "+name);
//            HttpSession session=request.getSession();
//            session.setAttribute("name",name);
//        }
//        else{
//            out.print("Sorry, username or password error!");
//            request.getRequestDispatcher("login.html").include(request, response);
//        }
//        out.close();

    }

}
