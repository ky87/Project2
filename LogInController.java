package com.ex.controllers;

import com.ex.service.LogInService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
@ResponseBody
public class LogInController {

    @GetMapping("/login")
    public void getCredentials(HttpServletRequest req) {
        String uname = req.getParameter("uname");
        String password = req.getParameter("psw");
        LogInService service = new LogInService();

        if(uname != null && password != null) {
            boolean status = service.tryLogIn(uname,password);
            if(status==true){
                ///go to home page
            }
            //send message invalid credentials
        }else {
            ///send error message
        }
    }
}
