package com.mddw.readers.THE_READERS.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("title", "Iniciar Sesión");
        return "user/sign-up";
    }
}
