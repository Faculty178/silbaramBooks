package com.project.silbaram.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private int bdid;
    private String title;
    private String content;
    private int memberId;
    private String pageType;
    private LocalDate regDate;

}
