package com.project.silbaram.controller;

import com.project.silbaram.dto.MemberDTO;
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

import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/")
public class SignupController {

    private final MemberServiceImpl memberService;


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
            return "redirect:/signup";
        }
        log.info(memberDTO);
        memberService.addMember(memberDTO);
        return "redirect:/index";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestBody String userId) {
        log.info("idCheck() : "+memberService.isDuplicatedUserId(userId));
        return memberService.isDuplicatedUserId(userId);
    }
    @PostMapping("/nickNameCheck")
    @ResponseBody
    public boolean nickNameCheck(@RequestBody String nickName) {
        log.info("nickNameCheck() : "+memberService.isDuplicatedUserNickName(nickName));
        return memberService.isDuplicatedUserNickName(nickName);
    }



    @Autowired
    private MailSendService mailSendService;
    //이메일 인증
    @GetMapping("/mailCheck")
    @ResponseBody
    public String mailCheck(String email) {
        System.out.println("이메일 인증 요청이 들어옴!");
        System.out.println("이메일 인증 이메일 : " + email);
        return mailSendService.joinEmail(email);
    }
}
