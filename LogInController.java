package com.ex.controllers;

import com.ex.dao.LogInDaoImpl;
import com.ex.model.Player;
import com.ex.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
//@RequestMapping("home")
@ResponseBody
public class LogInController {
    Player newProfile;
    LogInService LService;

    @Autowired
    public void setNewProfile(Player newProfile){
        this.newProfile = newProfile;
    }

    @Autowired
    public void setLService(LogInService LService) {
        this.LService = LService;
    }


    @GetMapping("/login")
    public void getCredentials(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String password = req.getParameter("psw");

        if (uname != null && password != null) {
            boolean status = LService.tryLogin(uname, password);

            if (status) {
                resp.setStatus(200);
                resp.sendRedirect("/home.html");
            } else {
                resp.sendError(400, "username or password invalid");
            }
        } else {
            resp.sendError(400, "insert an email or password");
        }

    }
    @PostMapping("/login")
    public void addNewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String newName = req.getParameter("newname");
        String newPassword = req.getParameter("pass");
        String location = req.getParameter("lcn");
        String gender = req.getParameter("sex");
        String age = req.getParameter("age");
        String rank = req.getParameter("skill");

        newProfile.setName(newName);
        newProfile.setPassword(newPassword);
        newProfile.setLocation(location);
        newProfile.setGender(gender);
        newProfile.setAge(Integer.parseInt(age));
        newProfile.setTennis_rank(Integer.parseInt(rank));



        LService.addNewProfile(newProfile);

    }
}
