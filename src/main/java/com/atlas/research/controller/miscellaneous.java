package com.atlas.research.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class miscellaneous {

    @GetMapping("/resetpassword")
    public String passwdreset(){
        return "passwdreset";
    }


}
