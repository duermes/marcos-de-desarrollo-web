package com.mddw.readers.THE_READERS.controller;

import com.mddw.readers.THE_READERS.dto.RegisterRequest;
import com.mddw.readers.THE_READERS.service.UserService;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/sign-up")
    public ModelAndView signUp(@Valid @ModelAttribute("registerRequest") RegisterRequest registerRequest,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("user/sign-up");
            mav.addObject("title", "Registro");
            return mav;
        }

        try {
            userService.register(registerRequest);
            redirectAttributes.addFlashAttribute("success", "Registro exitoso");
            return new ModelAndView("redirect:/user/log-in");
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView("user/sign-up");
            mav.addObject("title", "Registro");
            mav.addObject("error", e.getMessage());
            return mav;
        }
    }
    @PostMapping("/log-in")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Inicio de sesión exitoso");
            return "redirect:/library/libros-infantiles";
        } catch (AuthenticationException e) {
            model.addAttribute("error", "Credenciales inválidas");
            System.out.println(e.getMessage());
            return "";
        }
    }

}
