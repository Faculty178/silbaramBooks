package com.project.silbaram.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private int rid;
    private int memberId;
    private String title;
    private boolean reviewLike;
    private String content;
    private int bookId;
    private LocalDate regDate;


}
