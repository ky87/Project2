package com.ex.service;

import com.ex.dao.LogInDaoImpl;
import com.ex.model.Player;

import java.util.ArrayList;
import java.util.List;

public class LogInService {
    LogInDaoImpl LDao = new LogInDaoImpl();

    public boolean tryLogin (String name, String password){
//        List<Player> Players = LDao.findAll();
//        System.out.println(Players.toString());
//        for(Player checkPlayer : Players) {
//            if(name.equals(checkPlayer.getName()) && password.equals(checkPlayer.getPassword())){
//                return true;
//            }
//        }
//        return false;
        return false;
    }
}
