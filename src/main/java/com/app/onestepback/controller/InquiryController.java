package com.app.onestepback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/inquiry/*")
public class InquiryController {

    @GetMapping("list")
    public void goToListForm(){;}

    @GetMapping("write")
    public void goToWriteForm(){;}
}
