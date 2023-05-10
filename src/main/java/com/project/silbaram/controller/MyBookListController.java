package com.project.silbaram.controller;

import com.project.silbaram.service.MyBookListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/silbaram/mypage/mybooks")
public class MyBookListController {

    private final MyBookListService myBookListService;

    @GetMapping("/")
    public void MyBookListGET() {

    }




}
