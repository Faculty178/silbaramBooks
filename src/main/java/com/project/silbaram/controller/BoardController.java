package com.project.silbaram.controller;

import com.project.silbaram.dto.*;
import com.project.silbaram.service.BoardService;
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
@RequestMapping("/silbaram/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

/*
###책요청게시판 (한줄게시판)--페이지타입 'R'
    등록-로그인한 사람만
    수정기능X
    삭제-자기가 쓴 글인 경우 , 자신이 쓴 글인경우 글
    옆에 삭제버튼
    목록-상세페이지X, 페이징 처리

###문의게시판(기본 게시판)-페이지타입 'Q
    등록-로그인한 사람만(완)
    목록-페이징처리(완)
    수정-자신이 쓴 글일 경우에만 상세페이지에서 버튼 나타남 (완)
    삭제-자기가 쓴 글일 경우에만 상세페이지에서삭 제 버튼 나타남 (완)


 */
    //문의글 리스트
    @GetMapping("/list_qna")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        log.info("문의글 " + pageRequestDTO);

        //log.info("now {}", boardService.getNow());
        PageResponseDTO responseDTO = boardService.list(pageRequestDTO);
        log.info("responseDTO {}", responseDTO);
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
    }


    //문의글 get / post
    @GetMapping("/add_qna")
    public void registerQnAGET() {
        log.info("GET QnA board register");
    }

    @PostMapping("/add_qna")
    public String registerQnaPOST(@Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST qna register...");

        if (bindingResult.hasErrors()) {
            log.info("qna register has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/silbaram/board/add_qna";
        }
        log.info(boardDTO);
        boardService.register(boardDTO);
        return "redirect:/silbaram/board/list_qna";
    }


    //책 요청글 get / post
    @GetMapping("/request_book_list")
    public void registerRequestGET() {
        log.info("GET Request board register");
    }

    @PostMapping("/request_book_list")
    public String registerRequestPOST(@Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST request register...");

        if (bindingResult.hasErrors()) {
            log.info("Request register has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/silbaram/board/request_book_list";
        }
        log.info(boardDTO);

        boardService.register(boardDTO);
        return "redirect:/silbaram/board/request_book_list";
    }





    @GetMapping({"/read_qna", "/modify_qna"})
    public void read(int bdid, PageRequestDTO pageRequestDTO, Model model) {
        BoardDTO boardDTO = boardService.readOne(bdid);
        log.info(boardDTO);

        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify_qna")
    public String modify(PageRequestDTO pageRequestDTO, @Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) { //유효성 검가 결과 에러가 있으면 수정페이지로 돌아감
        log.info("----------modify---------");
        if (bindingResult.hasErrors()) {
            log.info("modify has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bdid", boardDTO.getBdid()); //tno가 쿼리스트링(like '?xx=1')으로 전달
            return "redirect:/silbaram/board/modify_qna";
        }
        log.info(boardDTO);
        boardService.modify(boardDTO);

        redirectAttributes.addAttribute("bdid", boardDTO.getBdid());

        return "redirect:/silbaram/board/read_qna";
    }

    @PostMapping("/remove")
    public String remove(int bdid, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("-------------remove------------");
        log.info("bdid: " + bdid);
        log.info("bdid: " + pageRequestDTO);

        boardService.remove(bdid);

        return "redirect:/silbaram/board/list_qna?" + pageRequestDTO.getLink();
    }





}
