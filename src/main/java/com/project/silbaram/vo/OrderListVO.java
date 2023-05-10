package com.project.silbaram.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderListVO {
    private Long oid;
    private Long bookId;
    private Long memberId;

    private int totalPrice;
    private LocalDate orderDate;
    private String orderNum;
}
