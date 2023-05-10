package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {

    private int rid;

    @NotEmpty
    private int memberId;

    @NotEmpty
    private String title;

    private boolean reviewLike;

    @NotEmpty
    private String content;

    @NotEmpty
    private int bookId;
}
