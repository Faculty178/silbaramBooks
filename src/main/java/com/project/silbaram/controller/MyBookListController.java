package com.project.silbaram.controller;

import com.project.silbaram.dto.OrderListDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.service.MyBookListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyBookListController {

    private final MyBookListService myBookListService;

        @GetMapping("/mybooks")
        public String MyBookListGET(Model model, HttpSession session, PageRequestDTO pageRequestDTO,OrderListDTO orderListDTO) {

            Long memberId = (Long) session.getAttribute("mid");
            orderListDTO.setMemberId(memberId);
            log.info(orderListDTO);

            PageResponseDTO responseDTO = myBookListService.getAllMyBooks(memberId, pageRequestDTO);
            log.info("responseDTO : " + responseDTO );
            model.addAttribute("responseDTO: " + responseDTO);
            model.addAttribute("pageRequestDTO: " + pageRequestDTO);

            return "silbaram/member/my_book_list";
        }




}
