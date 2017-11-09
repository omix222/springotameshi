package com.example.takahashi.springotamashi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    public static final String PAGE = "/login2";
    private static final String HTML = "login";

    @RequestMapping(value = LoginController.PAGE)
    public String top(Model model)
    {
        return LoginController.HTML;
    }
}
