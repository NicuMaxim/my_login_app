package com.test.my_login_app.controller;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TemplateController {

    @GetMapping("/")
    public String IndexPage() { return "redirect:hello"; }


    @GetMapping("/login")
    public String LoginPage(Model model) {
        model.addAttribute("title", "Login Page");
        return "login";
    }


    @GetMapping ("/hello")
    public String HelloPage(Model model) {
        model.addAttribute("title", "Success Page");
        return "hello";
    }

    // failed.html is used to handle user's email on fail and show it in the login form

        @PostMapping("/failed")
    public String LoginFailed(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String user,
                              Model model) {
        model.addAttribute("errorUser", user);
        model.addAttribute("title", "Failed Login Page");
        return "failed";
    }

    @GetMapping("/failed")
    public String LoginFailed() { return "redirect:hello"; }

}
