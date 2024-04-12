package com.encore.bbabap.api.comment;


import com.encore.bbabap.api.comment.request.CommentRequestDTO;
import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import com.encore.bbabap.service.comment.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@Tag(name = "게시판 - 댓글", description = "게시글에 대한 댓글을 관리하는 API")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @Operation(summary = "댓글 등록", description = "새로운 댓글을 등록하는 API")
    public ResponseEntity<CommentResponseDTO> addComment(@RequestBody CommentRequestDTO requestDTO) {
        CommentResponseDTO createdComment = commentService.addComment(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "댓글 삭제", description = "특정 댓글을 삭제하는 API - 삭제 여부로 판단")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/board/{boardId}")
    @Operation(summary = "게시글의 댓글 조회", description = "특정 게시글에 작성된 모든 댓글을 조회하는 API")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByBoardId(@PathVariable Long boardId) {
        List<CommentResponseDTO> comments = commentService.getAllCommentsByBoardId(boardId);
        return ResponseEntity.ok(comments);
    }
}
