package com.project.silbaram.dao;


import com.project.silbaram.vo.OrderListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBookListDAO {

    // 전체조회
    List<OrderListVO> selectAllMyBooks(Long memberId);

    List<OrderListVO> selectAllMyBooksBySpellASC(Long memberId);

    List<OrderListVO> selectOrderByMemberAndKeyword(long memberId, String keyword);


}
