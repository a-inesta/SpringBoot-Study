package com.hensel.springboot03web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@PathParam("username") String username, @RequestParam("password") String password, Model model
    , HttpSession session) {
        if (username != null && username.matches(".*")) {
            if (password != null && password.equals("123456")) {
                session.setAttribute("loginUser",username);
                return "redirect:/main.html";
            } else {
                model.addAttribute("msgPwd","密码错误!");
                return "index";
            }
        } else {
            model.addAttribute("msgName","用户名不存在!");
            return "index";
        }
    }

}
