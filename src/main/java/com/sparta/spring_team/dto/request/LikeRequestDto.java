package com.sparta.spring_team.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequestDto {

    @NotBlank
    private String likeType;

    @NotNull
    private Long data;
}
