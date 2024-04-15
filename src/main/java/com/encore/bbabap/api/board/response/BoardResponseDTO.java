package com.encore.bbabap.api.board.response;

import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private Long commentCount;
    private List<CommentResponseDTO> comments;
}