package com.project.silbaram.controller;

import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import com.project.silbaram.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberModifyController {

    private final MemberServiceImpl memberService;


    @GetMapping("/mypage/membermodify")
    public String memberModifyGET(Model model, HttpSession session) {
        Long mid = (Long) session.getAttribute("mid");
        if (mid == null) { // 로그인하지 않은 사용자는 로그인 페이지로 이동
            return "redirect:/login";
        }
        // 로그인한 사용자는 마이페이지로 이동
        MemberDTO memberDTO = memberService.getMemberByMid(mid); // 회원정보를 조회함
        log.info(memberDTO);
        model.addAttribute("memberDTO", memberDTO);
        return "silbaram/member/member_modify";
    }

    @PostMapping("/mypage/membermodify")
    public String memberModifyPOST(@Valid MemberModifyDTO memberModifyDTO, MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getAllErrors());
            return "redirect:/mypage/membermodify";
        }

        memberService.modifyMember(memberModifyDTO);
        session.setAttribute("mid", memberDTO.getMid());
        return "redirect:/mypage/membermodify";
    }

    @GetMapping("/mypage/resetpw")
    public String passwordModifyGET(Model model, HttpSession session) {
        Long mid = (Long) session.getAttribute("mid");
        if (mid == null) { // 로그인하지 않은 사용자는 로그인 페이지로 이동
            return "redirect:/login";
        }
        // 로그인한 사용자는 비밀번호 변경 이동
        MemberDTO memberDTO = memberService.getMemberByMid(mid); // 회원정보를 조회함
        log.info(memberDTO);
        model.addAttribute("memberDTO", memberDTO);
        return "silbaram/member/reset_pw";
    }

    @PostMapping("/mypage/resetpw")
    public String passwordModifyPOST(@Valid MemberModifyDTO memberModifyDTO, MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getAllErrors());
            return "redirect:/mypage/resetpw";
        }

        memberService.modifyMemberPw(memberModifyDTO);
        session.setAttribute("mid", memberDTO.getMid());
        return "redirect:/mypage/resetpw";
    }


    @PostMapping("/mypage/checkpw")
    public String checkPwPOST(Model model, HttpSession session) {

        Long mid = (Long) session.getAttribute("mid");
        MemberDTO memberDTO = memberService.getMemberByMid(mid); // 회원정보를 조회함
        log.info(memberDTO);
        model.addAttribute("memberDTO", memberDTO);
        model.getAttribute("oldPassword");

        return "redirect:/mypage/resetpw";
    }

}
