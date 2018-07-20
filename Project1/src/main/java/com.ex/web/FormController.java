package com.ex.web;

import com.ex.dao.FormDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.ex.web.LoginController.loginSession;

public class FormController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Inside controller");

        while (loginSession == true) {

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            req.getRequestDispatcher("createForm.html").include(req, resp);

            Integer eid = Integer.valueOf(req.getParameter("eid"));
            String date = req.getParameter("date");
            String time = req.getParameter("time");
            String location = req.getParameter("place");
            Integer ecost = Integer.valueOf(req.getParameter("cost"));
            String etype = req.getParameter("type");
            String egrade = req.getParameter("grade");
            String description = req.getParameter("des");

            FormDao.createForm(eid, date, time, location, ecost, etype, egrade, description);

            System.out.println("Form created.");

        }

    }
}
