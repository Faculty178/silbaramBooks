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
public class MemberModifyDTO {
    private Long mid;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String email;
    private String zipcode;
    private String address;

}