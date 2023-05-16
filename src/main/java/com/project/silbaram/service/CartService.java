package com.project.silbaram.service;

import com.project.silbaram.dto.CartDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CartService {

    void addCart(CartDTO cartDTO); // 카트 추가

    List<CartDTO> getAll(Long mid); // 카트 목록 불러오기

    void remove(Long lkid); // 카트 삭제
}
