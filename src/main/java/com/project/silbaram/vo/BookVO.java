package com.project.silbaram.vo;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
    private int bkid;
    private String name;
    private String publisher;
    private int price;
    private String synopsis;
    private int pages;
    private String isbnNum;
    private int category;
    private String fileSize;
    private int language;
    private String voiceLength;
    private String bookUrl;
    private String bookTextUrl;
    private String bookImage;




}
