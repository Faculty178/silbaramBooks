package com.project.silbaram.controller;

import com.project.silbaram.dto.BookDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silbaram/product")
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;



    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO responseDTO = bookService.list(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping("/book_detail")
    public void selectOneBook(int bkid, PageRequestDTO pageRequestDTO, Model model) {
        BookDTO bookDTO = bookService.readOne(bkid);
        log.info(bookDTO);
        model.addAttribute("dto", bookDTO);
    }


}
