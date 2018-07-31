package com.ex.web;

import com.ex.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class LoginController extends HttpServlet {
    public static boolean loginSession;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/home.html").forward(req, resp);
//        Reader r = req.getReader();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("login.html").include(req, resp);

        String name = req.getParameter("uname");
        String password = req.getParameter("psw");
        String user = req.getParameter("type");

        if (user != "supervisor" || user != "department head" || user != "benefits coordinator" || user != "") {
            System.out.println("Not an admin type.");
        }

        if (LoginDao.login(name, password, user) == true) {
            req.getRequestDispatcher("home.html").forward(req, resp);
            loginSession = true;
            System.out.println("Logged in.");
        } else {
            req.getRequestDispatcher("login.html").forward(req, resp);
            System.out.println("Wrong password");
        }


    }
}
