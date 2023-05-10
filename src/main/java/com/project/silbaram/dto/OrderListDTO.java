package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderListDTO {
    private Long oid;
    private Long bookId;
    private Long memberId;

    private int totalPrice;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate orderDate;
    private String orderNum;
}
