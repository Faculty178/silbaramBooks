package com.project.silbaram.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/silbaram")
public class MyBookListController {

    @GetMapping("/mybooklist")
    public String myBookListGET(){
        return "silbaram/member/my_book_list";
    }
}
