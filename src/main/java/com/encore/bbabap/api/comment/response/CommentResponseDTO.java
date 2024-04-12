package com.encore.bbabap.api.comment.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CommentResponseDTO {
    private Long boardId;
    private Long id;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;
}
