package com.encore.bbabap.domain.board;


import com.encore.bbabap.domain.comment.Comment;
import com.encore.bbabap.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean deletedYn = false;

    private LocalDateTime deletedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();


    @Builder
    public Board(Long id, String title, String content, LocalDateTime registeredAt, LocalDateTime updatedAt, Boolean deletedYn, LocalDateTime deletedAt, User user, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.registeredAt = registeredAt != null ? registeredAt : LocalDateTime.now();
        this.updatedAt = updatedAt;
        this.deletedYn = deletedYn;
        this.deletedAt = deletedAt;
        this.user = user;
        if (comments != null) {
            this.comments = new ArrayList<>(comments); // 새로운 ArrayList로 초기화
        }
    }

    public void updateContent(String title, String content, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
    }

    public void deleteContent(boolean deletedYn, LocalDateTime deletedAt) {
        this.deletedYn = deletedYn;
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return deletedYn;
    }
}
