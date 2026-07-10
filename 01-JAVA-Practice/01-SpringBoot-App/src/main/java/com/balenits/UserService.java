package com.balenits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService(){
        System.out.println("UserService :: Constructor Executed");
    }

    public String getName(Integer id){
        return userDao.findNameById(id);
    }
}
