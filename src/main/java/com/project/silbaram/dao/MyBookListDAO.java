package com.project.silbaram.dao;


import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.OrderListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBookListDAO {

    void insertOrder(OrderListVO orderListVO);

    // 전체조회
    List<OrderListVO> selectAllMyBooks(Long memberId, PageRequestDTO PageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

//    List<OrderListVO> selectAllMyBooksBySpellASC(Long memberId);
//
//    List<OrderListVO> selectOrderByMemberAndKeyword(long memberId, String keyword);


}
