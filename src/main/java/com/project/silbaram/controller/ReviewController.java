package com.project.silbaram.controller;

import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.dto.ReviewDTO;
import com.project.silbaram.service.ReviewService;
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
@RequestMapping("/silbaram/review")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO responseDTO = reviewService.list(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET review register...");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid ReviewDTO reviewDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("POST review register...");

        //hasErrors()를 이용해서 검증에 문제가 있다면 다시 입력화면으로 리다이렉트 되도록 처리
        //처리과정에서 잘못된 결과는 addFlashAttribute()를 이용해서 전달
        //@notEmpty때문에 입력하지 않으면 다시 입력화면으로 돌아감
        if (bindingResult.hasErrors()) {
            log.info("review register has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/silbaram/review/register";
        }
        log.info(reviewDTO);
        reviewService.register(reviewDTO);
        return "redirect:/silbaram/review/list";
    }

    // /todo/modify?tno=xxx의 경로 처리하도록
    @GetMapping({"/read", "/modify"})
    public void read(int rid, PageRequestDTO pageRequestDTO, Model model) {
        ReviewDTO reviewDTO = reviewService.readOne(rid);
        log.info(reviewDTO);

        model.addAttribute("dto", reviewDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid ReviewDTO reviewDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) { //유효성 검가 결과 에러가 있으면 수정페이지로 돌아감
        log.info("----------modify--------");
        if (bindingResult.hasErrors()) {
            log.info("modify has error...");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("rid", reviewDTO.getRid()); //tno가 쿼리스트링(like '?xx=1')으로 전달
            return "redirect:/silbaram/review/modify";
        }
        log.info(reviewDTO);
        reviewService.modify(reviewDTO);

        redirectAttributes.addAttribute("rid", reviewDTO.getRid());

        return "redirect:/silbaram/review/read";
    }

    @PostMapping("/remove")
    public String remove(int rid, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("-------------remove------------");
        log.info("rid: " + rid);
        log.info("rid: " + pageRequestDTO);

        reviewService.remove(rid);

        return "redirect:/silbaram/review/list?" + pageRequestDTO.getLink();
    }

}
