package com.project.silbaram.controller;

import com.project.silbaram.dto.BookDTO;
import com.project.silbaram.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("silbaram/admin")
public class AdminBookController {
    private final BookServiceImpl bookService;

    @GetMapping("/addbook")
    public String addBookGET(Model model) {
        log.info("addBookGET...");
        model.addAttribute("bookDTO", new BookDTO());
        return "/silbaram/admin/addbook";
    }

    @PostMapping("/addbook")
    public String addBookPOST(@Valid BookDTO bookDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        log.info("addBookPOST...");
        log.info(bookDTO);
        if(bindingResult.hasErrors()) {
            log.info("has error...");
            log.info(bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/silbaram/admin/addbook";
        }
        log.info(bookDTO);
        bookService.insertBook(bookDTO);
        return "redirect:/silbaram/admin/admin_book_list";
    }
}
