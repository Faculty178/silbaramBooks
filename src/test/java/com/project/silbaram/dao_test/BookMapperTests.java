package com.project.silbaram.dao_test;

import com.project.silbaram.dao.BookDAO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.BookVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class BookMapperTests {

    @Autowired
    private BookDAO bookDAO;

    @Test
    public void testSelectOne() {
        BookVO bookVO = bookDAO.selectOne(2001);
        log.info(bookVO);
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<BookVO> voList = bookDAO.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
    }
}
