package com.project.silbaram.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private Long rid;
    private Long memberId;
    private String title;
    private boolean reviewLike;
    private String content;
    private Long bookId;
    private LocalDate regDate;


}
