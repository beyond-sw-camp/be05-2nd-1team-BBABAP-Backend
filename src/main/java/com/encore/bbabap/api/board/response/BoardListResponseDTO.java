package com.encore.bbabap.api.board.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardListResponseDTO {
    private Long id;
    private String title;
    private String nickname;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private Long commentCount;
}
