package com.app.onestepback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/")
public class MainController {

    // 메인 페이지
    @GetMapping
    public String goToMainForm(Model model) {
        model.addAttribute("currentPage", "home");
        return "/main/main";
    }
}
