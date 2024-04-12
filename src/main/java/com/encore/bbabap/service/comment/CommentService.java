package com.encore.bbabap.service.comment;



import com.encore.bbabap.api.comment.request.CommentRequestDTO;
import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import com.encore.bbabap.config.SecurityUtils;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.comment.Comment;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.Comment.CommentRepository;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDTO addComment(CommentRequestDTO requestDTO) {

        Board board = boardRepository.findById(requestDTO.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + requestDTO.getBoardId()));

        // 삭제된 게시글에 댓글이 등록되는 것을 방지
        if (board.isDeleted()) {
            throw new RuntimeException("Cannot add comment to a deleted board.");
        }

        String userEmail = SecurityUtils.getCurrentUserEmail();

        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + userEmail);
        }

        Comment comment = Comment.builder()
                .content(requestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .user(user)
                .board(board)
                .deletedYn(false)
                .build();

        Comment savedComment = commentRepository.save(comment);

        // Comment 객체를 DTO로 변환하여 반환
        return convertToDTO(savedComment);
    }

    @Transactional
    public void deleteComment(Long commentId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with id: " + commentId));

        // 이미 삭제된 댓글인지 확인
        if (comment.isDeleted()) {
            throw new RuntimeException("This comment has already been deleted.");
        }

        String userEmail = SecurityUtils.getCurrentUserEmail();

        // 사용자 권한 확인: 댓글 작성자만 삭제할 수 있도록
        if (!comment.getUser().getEmail().equals(userEmail)) {
            throw new RuntimeException("You do not have permission to delete this comment.");
        }

        comment.deleteComment(true, LocalDateTime.now());

        // 실제로 데이터를 삭제하는 경우
        // commentRepository.delete(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDTO> getAllCommentsByBoardId(Long boardId) {
        Board board = boardRepository.findByIdAndDeletedYnFalse(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + boardId));

        // 삭제된 게시글의 댓글은 조회하지 않음
        List<Comment> comments = board.getComments().stream()
                .filter(comment -> !comment.isDeleted())
                .toList();

        return comments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CommentResponseDTO convertToDTO(Comment comment) {
        return CommentResponseDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .nickname(comment.getUser().getNickname())
                .boardId(comment.getBoard().getId())
                .build();
    }
}
