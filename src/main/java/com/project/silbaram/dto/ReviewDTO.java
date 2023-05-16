package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {

    private Long rid;

    @NotEmpty
    private Long memberId;

    @NotEmpty
    private String title;

    private boolean reviewLike;

    @NotEmpty
    private String content;

    @NotEmpty
    private Long bookId;
}
