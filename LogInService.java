package com.ex.service;
import com.ex.dao.LogInDaoImpl;
import com.ex.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogInService {
    @Autowired
    LogInDaoImpl LDao = new LogInDaoImpl();

    @Transactional
    public boolean tryLogin (String name, String password){
        List<Player> Players = LDao.findAll();

        for(Player checkPlayer : Players) {
            if(name.equals(checkPlayer.getName()) && password.equals(checkPlayer.getPassword())){
                return true;
            }
        }

        return false;
    }

    @Transactional
    public void addNewProfile(Player profile){
        LDao.insert(profile);
    }
}
