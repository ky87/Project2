package com.ex.controllers;


import com.ex.dao.HomeDaoImpl;
import com.ex.model.Court;
import com.ex.model.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("/home")

public class HomeController {
    HomeDaoImpl hDao;

    @Autowired
    public void sethDao (HomeDaoImpl hDao ){this.hDao=hDao;}

    @GetMapping(path="/home" )
    public List<Court> getCourts () {
        List<Court> courts = hDao.findAll();
        System.out.println(courts.toString());

        return courts;

    }

}
