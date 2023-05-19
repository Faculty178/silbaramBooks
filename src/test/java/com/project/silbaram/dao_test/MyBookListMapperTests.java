package com.project.silbaram.dao_test;

import com.project.silbaram.dao.MyBookListDAO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.BoardVO;
import com.project.silbaram.vo.OrderListVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
public class MyBookListMapperTests {

    @Autowired
    private MyBookListDAO myBookListDAO;

    @Test
    public void insertDummy() {
        int i;
        Long l;
        Long bookNum = 2001L;
        for (i = 1; i < 300; i++) {
            if (bookNum < 2010L) {
                bookNum++;
            }
            else if (bookNum == 2010L) {
                bookNum = 2001L;
            }
            OrderListVO orderListVO = OrderListVO.builder()
                    .bookId(bookNum)
                    .memberId(3L)
                    .totalPrice(10000)
                    .orderNum(String.valueOf(i))
                    .build();

            log.info(orderListVO);
            myBookListDAO.insertOrder(orderListVO);
        }
    }


    @Test
    public void searchTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(12)
                .types(new String[]{"n","w","nw"})
                .keyword("D")
                .build();
        log.info(pageRequestDTO);
        Long memberId = 3L;
        List<OrderListVO> voList = myBookListDAO.selectAllMyBooks(pageRequestDTO, memberId);
        log.info(voList);
        voList.forEach(vo -> log.info(vo));
    }


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
