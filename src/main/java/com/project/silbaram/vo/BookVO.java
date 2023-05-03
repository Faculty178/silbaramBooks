package com.project.silbaram.vo;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
    private int bkid;
    private String name;
    private String writer;
    private String publisher;
    private int price;
    private String synopsis;
    private int pages;
    private String isbnNum;
    private String category;
    private String fileSize;;
    private int language;
    private String voiceLength;
    private String bookUrl;

}
