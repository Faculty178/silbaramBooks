package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Long bkid;
    @NotBlank(message = "책 이름을 입력해주세요.")
    private String name;
    @NotBlank(message = "책 내용을 입력해주세요.")
    private String writer;
    @NotBlank(message = "작가 이름을 입력해주세요.")
    private String publisher;
    @NotNull
    private int price;
    private String synopsis;
    private int pages;
    private String isbnNum;
    @NotNull
    private Long category;
    private String fileSize;
    @NotNull
    private Long language;
    private String voiceLength;
    private String bookUrl;

}
