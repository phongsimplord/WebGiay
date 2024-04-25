package com.example.website.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @RequestMapping("/admin/dash-board")
    public String DashBoard() {
        return "DashBoard/index";
    }

    @RequestMapping("/login")
    public String Login() {
        return "Authetication/authentication-login";
    }

    @RequestMapping("/register")
    public String Register() {
        return "Authetication/authentication-register";
    }

    @RequestMapping("/ui-icon")
    public String uiIcon() {
        return "UI/icon-tabler";
    }

    @RequestMapping("/ui-forms")
    public String uiForms() {
        return "UI/ui-forms";
    }

    @RequestMapping("/ui-buttons")
    public String uiButtons() {
        return "UI/ui-buttons";
    }
}
