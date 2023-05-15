package com.project.silbaram.service_test;

import com.project.silbaram.dto.OrderListDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.service.MyBookListService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MyBookListServiceTests {

    @Autowired
    private MyBookListService myBookListService;

    @Test
    public void searchServiceTest() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(12)
                .types(new String[]{"n","w","nw"})
                .keyword("D")
                .build();
        log.info(pageRequestDTO);
        Long memberId = 3L;
        PageResponseDTO<OrderListDTO> voList = myBookListService.getAllMyBooks(pageRequestDTO, memberId);
        log.info(voList);

    }
}
