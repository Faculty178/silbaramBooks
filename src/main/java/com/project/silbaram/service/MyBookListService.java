package com.project.silbaram.service;

import com.project.silbaram.dto.OrderListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyBookListService {

    List<OrderListDTO> getAllMyBooks(Long memberId);
    List<OrderListDTO> getAllMyBooksBySpellASC(Long memberId);

    List<OrderListDTO> getOrderByMemberAndKeyword(long memberId, String keyword);

}
