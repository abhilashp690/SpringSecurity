package com.SpringSecurity.SpringSecurity.ThymLeafController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class ThymLeafController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("loggedin")
    public String getLoggedinView() {
        return "LoggedIn";
    }
}
