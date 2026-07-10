package com.balenits;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public UserDao() {
        System.out.println("UserDao :: Constructor");
    }


    public String findNameById(Integer id) {
        if (id > 100) {
            return "Raju";
        } else {
            return "Rani";
        }
    }
}
