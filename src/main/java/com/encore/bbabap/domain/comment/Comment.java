package com.encore.bbabap.domain.comment;


import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private Boolean deletedYn;

    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public Comment(Long id, String content, LocalDateTime createdAt, Boolean deletedYn, LocalDateTime deletedAt, User user, Board board) {
        this.id = id;
        this.content = content;
        this.deletedYn = deletedYn;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.deletedAt = deletedAt;
        this.user = user;
        this.board = board;
    }

    public void deleteComment(boolean deletedYn, LocalDateTime deletedAt) {
        this.deletedYn = deletedYn;
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return deletedYn;
    }
}
