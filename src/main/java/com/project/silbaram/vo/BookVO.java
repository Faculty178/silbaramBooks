package com.project.silbaram.vo;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
    private Long bkid;
    private String name;
    private String writer;
    private String publisher;
    private int price;
    private String synopsis;
    private int pages;
    private String isbnNum;
    private Long category;
    private String fileSize;;
    private Long language;
    private String voiceLength;
    private String bookUrl;

}
