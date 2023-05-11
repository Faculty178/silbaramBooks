package com.project.silbaram.dao_test;

import com.project.silbaram.dao.MyBookListDAO;
import com.project.silbaram.vo.OrderListVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class MyBookListMapperTests {

    @Autowired
    private MyBookListDAO myBookListDAO;



//    @Test
//    public void getAllMyBooksTest() {
//        Long memberId = 7L; // 회원 ID 값
//        List<OrderListVO> voList = myBookListDAO.selectAllMyBooks(memberId);
//        for (OrderListVO orderListVO : voList) {
//            log.info("테스트: " + orderListVO);
//        }
//    }

//    @Test
//    public void getAllMyBooksBySpellASCTest() {
//        Long memberId = 7L; // 회원 ID 값
//        List<OrderListVO> voList = myBookListDAO.selectAllMyBooksBySpellASC(memberId);
//        for (OrderListVO orderListVO : voList
//        ){
//            log.info(orderListVO);
//        }
//    }



}
