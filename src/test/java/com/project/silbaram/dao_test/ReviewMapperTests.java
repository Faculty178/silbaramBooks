package com.project.silbaram.dao_test;

import com.project.silbaram.dao.BoardDAO;
import com.project.silbaram.dao.ReviewDAO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.BoardVO;
import com.project.silbaram.vo.ReviewVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
public class ReviewMapperTests {

    @Autowired
    private ReviewDAO reviewDAO;

    @Test
    public void testGetTime() {
        log.info(reviewDAO.getNow());
    }

    @Test
    public void testInsert() {
        ReviewVO reviewVO = ReviewVO.builder()
                .title("ReviewTest2")
                .content("리뷰테스트1")
                .memberId(1001)
                .regDate(LocalDate.of(2023, 05, 06))
                .bookId(2001)
                .reviewLike(false)
                .build();
        reviewDAO.insert(reviewVO);
    }

    @Test
    public void testSelectOne() {
        ReviewVO reviewVO = reviewDAO.selectOne(3001);
        log.info(reviewVO);
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<ReviewVO> voList = reviewDAO.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testUpdate() {
        ReviewVO reviewVO = ReviewVO.builder()
                .rid(3001)
                .memberId(1001)
                .title("리뷰테스트업데이트")
                .reviewLike(false)
                .content("ReviewUpdateTest")
                .regDate(LocalDate.of(2023, 05, 04))
                .bookId(2001)
                .build();

        reviewDAO.update(reviewVO);
    }

    @Test
    public void testDelete() {
        List<ReviewVO> list = reviewDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));

        reviewDAO.delete(3001);

        //삭제 확인
        list = reviewDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }


}
