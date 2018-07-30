package com.ex.controllers;

import com.ex.dao.LogInDaoImpl;
import com.ex.model.Player;
import com.ex.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("home")
@ResponseBody
public class LogInController {
    LogInDaoImpl LDao;

    @Autowired
    public void setLDao(LogInDaoImpl LDao){this.LDao=LDao;}

    @GetMapping("/login")
    public void getCredentials(HttpServletRequest req) {
        String uname = req.getParameter("uname");
        String password = req.getParameter("psw");
        LogInService service = new LogInService();


        System.out.println(uname);

//
//
        List<Player> players = LDao.findAll();
        System.out.println(players.toString());
//        System.out.println(result);

//        for(Player checkPlayer : Players) {
//            if(name.equals(checkPlayer.getName()) && password.equals(checkPlayer.getPassword())){
//                System.out.println("check works");
//            }
        }



//        if(uname != null && password != null) {
//            boolean status = service.tryLogin(uname,password);
//            if(status==true){
//            }
//            //send message invalid credentials
//        }else {
//            ///send error message
//        }
//    }
}
