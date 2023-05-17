package com.project.silbaram.controller;

import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import com.project.silbaram.email.MailSendService;
import com.project.silbaram.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {
    private final MemberServiceImpl memberService;

    @GetMapping({"/", "","/index"})
    public String  index() {
        return "silbaram/index";
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
            return "redirect:/login";
        }
        session.setAttribute("mid", mid);
        log.info("login success!");
        return "redirect:/index";
    }


    @PostMapping("/logout")
    public String logoutPOST(HttpServletRequest request) {
        //세션을 삭제
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/index";
    }

    @GetMapping("/mypage")
    public String mypage(HttpSession session) {
        if(session.getAttribute("mid") == null) { // 로그인하지 않은 사용자는 로그인 페이지로 이동
            return "redirect:/login";
        }
        // 로그인한 사용자는 마이페이지로 이동
        return "silbaram/member/mypage";
    }


}