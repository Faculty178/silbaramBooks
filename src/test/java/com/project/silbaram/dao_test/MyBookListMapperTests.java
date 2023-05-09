package com.project.silbaram.dao_test;

import com.project.silbaram.dao.MyBookListDAO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MyBookListMapperTests {

    @Autowired
    private MyBookListDAO myBookListDAO;

    @Test
    public void getAllMyBooksTest() {
        myBookListDAO.getAllMyBooks();
    }
}
