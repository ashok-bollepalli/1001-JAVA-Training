package com.balenits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getWelcomeMsg(@PathVariable Integer id) {
        String name = userService.getName(id);
        return name + ", Welcome to REST APIs";
    }
}
