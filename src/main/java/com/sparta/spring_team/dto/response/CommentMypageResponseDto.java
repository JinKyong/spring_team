package com.sparta.spring_team.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentMypageResponseDto {
    private Long id;
    private String membername;
    private String content;
    private Long likeNum;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
