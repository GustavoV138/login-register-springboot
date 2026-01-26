package com.vieira.login_register_fullstack_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteHtmlController {

    @GetMapping("/")
    public String exibirSite() {
        return "redirect:htmls/login.html";
    }
}


