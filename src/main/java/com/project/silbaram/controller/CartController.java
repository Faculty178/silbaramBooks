package com.project.silbaram.controller;

import com.project.silbaram.service.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "/silbaram")
public class CartController {
    // ajax용 백업 코드
    /*@ApiOperation(value = "Replies of Board", notes = "POST 방식으로 특정 유저(memberId로 판별)의 장바구니 목록")
    @PostMapping("/cart/cart_list/{memberId}")
    public void list(@PathVariable("memberId") int memberId, Model model) {
        model.addAttribute("dtoList", cartService.getAll());
        log.info(model.getAttribute("dtoList"));
    }

    // 수정중인 코드 (ajax로 삭제 처리 위해 백업)
    @GetMapping("/cart/cart_list/{lkid}")
    public void deleteFromCart(@PathVariable int lkid) {
        log.info("deleteFromCart.....");
        cartService.remove(lkid);
    }*/

    private final CartServiceImpl cartService;

    @GetMapping("/cart/cart_list")
    public void list(Model model, HttpSession session) {
        Long mid = (Long) session.getAttribute("mid");
        model.addAttribute("dtoList", cartService.getAll(mid));
        log.info("cart_list...");
    }

    @PostMapping("/cart/deleteCart")
    public void deleteFromCart(Long lkid) {
        log.info("deleteFromCart.....");
        cartService.remove(lkid);
    }

}
