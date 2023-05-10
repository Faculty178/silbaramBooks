package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
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
