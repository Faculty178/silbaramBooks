package com.project.silbaram.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthControllerV1 {

    @GetMapping("/login/oauth2/code/kakao")
    public String home(String code) {
        return "인증 코드 : " + code;
    }
}