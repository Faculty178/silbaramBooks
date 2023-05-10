package com.project.silbaram.dao_test;


import com.project.silbaram.dao.CartDAO;
import com.project.silbaram.dto.CartDTO;
import com.project.silbaram.service.CartServiceImpl;
import com.project.silbaram.vo.CartVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class CartMapperTests {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private CartServiceImpl cartService;


    /*@Test
    public void testInsertCart() { // 카트 삽입 테스트
        CartVO cartVO = CartVO.builder()
                .memberId(1002)
                .bookId(2008)
                .build();
        cartDAO.insertCart(cartVO);
    }*/

    // 카트 리스트 불러오기
    /*@Test
    public void testSelectAll() {
        List<CartVO> voList = cartDAO.selectAll();
        voList.forEach(vo -> log.info(vo));
        log.info("totalPrice: " + cartDAO.getTotalPrice(1001)); //카트 총합 가격 계산하기
    }*/

    @Test
    public void getAllTests(){
        // 이 테스트가 안 되는데 왜 안 되는지 알려주시면 감사하겠습니다...
        List<CartDTO> cartDTOS = cartService.getAll(1001L);
        log.info(cartDTOS);
    }

    @Test
    public void selectAllTest(){
        List<CartVO> cartDTOS = cartDAO.selectAll(1001L);
        log.info("cartDTOS: " + cartDTOS);
    }

    @Test
    public void deleteTests(){
//        cartDAO.delete(6003);
        cartService.remove(6005L);

    }
}
