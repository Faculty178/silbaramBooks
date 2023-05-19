package com.project.silbaram.vo;

import com.project.silbaram.dto.BookDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderListVO {

    private Long ogid;
    private Long bookId;
    private Long memberId;

    private int totalPrice;
    private LocalDate orderDate;
    private String orderNum;

    /* book */
    private BookDTO book;
    private String bookName;
    private String writerName;



}
