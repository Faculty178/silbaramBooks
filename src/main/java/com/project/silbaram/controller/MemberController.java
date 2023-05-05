package com.project.silbaram.controller;

import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import com.project.silbaram.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/silbaram")
public class MemberController {
    private final MemberServiceImpl memberService;

    @GetMapping({"/", "","/index"})
    public String  index() {
        return "silbaram/index";
    }

    @GetMapping("/signup")
    public String  addMemberGET(Model model) {

        log.info("addMemberGET...");
        model.addAttribute("memberDTO", new MemberDTO());
        return "silbaram/signup/signup";
    }
    @PostMapping("/signup")
    public String addMemberPOST(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("addMemberPOST...");
        if (bindingResult.hasErrors()) {
            log.info("has error...");
            log.info(bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/silbaram/signup";
        }
        log.info(memberDTO);
        memberService.addMember(memberDTO);
        return "redirect:/silbaram/index";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestBody String userId) {
        log.info("idCheck() : "+memberService.isDuplicatedUserId(userId));
        return memberService.isDuplicatedUserId(userId);
    }



    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "silbaram/member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String password,
                        HttpSession session, Model model) {
        Long mid = memberService.login(userId, password);

        if(mid == null) {
            log.info("login fails!");
            model.addAttribute("msg","아이디와 비밀번호를 확인해주세요");
            return "redirect:/silbaram/login";
        }
        session.setAttribute("mid", mid);
        log.info("login success!");
        return "redirect:/silbaram/index";
    }


    @PostMapping("/logout")
    public String logoutPOST(HttpServletRequest request) {
        //세션을 삭제
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/silbaram/index";
    }

    @GetMapping("/mypage")
    public String mypage(HttpSession session) {
        if(session.getAttribute("mid") == null) { // 로그인하지 않은 사용자는 로그인 페이지로 이동
            return "redirect:/silbaram/login";
        }
        // 로그인한 사용자는 마이페이지로 이동
        return "silbaram/member/mypage";
    }

    @GetMapping("/mypage/membermodify")
    public String memberModifyGET(Model model, HttpSession session) {
        Long mid = (Long) session.getAttribute("mid");
        if (mid == null) { // 로그인하지 않은 사용자는 로그인 페이지로 이동
            return "redirect:/silbaram/login";
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
            return "redirect:/silbaram/mypage/membermodify";
        }

        memberService.modifyMember(memberModifyDTO);
        session.setAttribute("mid", memberDTO.getMid());
        return "redirect:/silbaram/mypage/membermodify";
    }





}