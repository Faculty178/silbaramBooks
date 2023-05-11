package com.project.silbaram.service;

import com.project.silbaram.dto.OrderListDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyBookListService {

    PageResponseDTO<OrderListDTO> getAllMyBooks(Long memberId,PageRequestDTO pageRequestDTO);
//    List<OrderListDTO> getAllMyBooksBySpellASC(Long memberId);
//
//    List<OrderListDTO> getOrderByMemberAndKeyword(long memberId, String keyword);

}
