package com.project.silbaram.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private Long bdid;
    private String title;
    private String content;
    private Long memberId;
    private String pageType;
    private LocalDate regDate;

}
