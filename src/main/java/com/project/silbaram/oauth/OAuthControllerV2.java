package com.project.silbaram.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.silbaram.oauth.OAuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
public class OAuthControllerV2 {
    private final ObjectMapper objectMapper;


    @GetMapping("/login/oauth2/code/kakao")
    public OAuthToken home(String code) {

        // 3. 인증 코드를 받은 후, 파라미터들을 포함해 토큰 요청
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code"); // 고정값
        params.add("client_id", "2d4da76a7e51b2d482ac929a10ee544b");
        params.add("redirect_uri", "http://localhost:8080/login/oauth2/code/kakao");
        params.add("code", code);

        // HttpHeader 오브젝트 생성
        HttpHeaders headersForAccessToken = new HttpHeaders();
        headersForAccessToken.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headersForAccessToken);

        // POST방식으로 key-value 데이터를 요청(카카오쪽으로)
        RestTemplate rt = new RestTemplate(); //http 요청을 간단하게 해줄 수 있는 클래스

        // 실제로 요청하기
        // Http 요청하기 - POST 방식으로 - 그리고 response 변수에 응답을 받음.
        ResponseEntity<String> accessTokenResponse = rt.exchange(
            "https://kauth.kakao.com/oauth/token",
            HttpMethod.POST,
            kakaoTokenRequest,
            String.class
        );

        // JSON 응답을 객체로 변환
        OAuthToken oauthToken = null;
        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OAuthToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return oauthToken;
    }
}