package com.mddw.readers.THE_READERS.controller;


import com.mddw.readers.THE_READERS.dto.RegisterRequest;
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
        model.addAttribute("registerRequest", new RegisterRequest());
        return "user/sign-up";
    }
    @GetMapping("/log-in")
    public String login(Model model){
        model.addAttribute("title", "Iniciar Sesión");
        return "user/log-in";
    }
}
