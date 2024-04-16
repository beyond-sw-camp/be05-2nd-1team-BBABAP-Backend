package com.encore.bbabap.api.board;


import com.encore.bbabap.api.board.request.BoardRequestDTO;
import com.encore.bbabap.api.board.response.BoardListResponseDTO;
import com.encore.bbabap.api.board.response.BoardResponseDTO;
import com.encore.bbabap.service.board.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "게시판 - 게시글", description = "사용자가 게시글을 작성, 조회, 수정, 삭제하는 API")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @Operation(summary = "게시글 등록", description = "새로운 게시글을 등록하는 API")
    public ResponseEntity<BoardResponseDTO> createBoard(@RequestBody BoardRequestDTO requestDTO) {
        BoardResponseDTO createdBoard = boardService.createBoard(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoard);
    }

    @GetMapping
    @Operation(summary = "전체 게시글 조회", description = "모든 게시글을 조회하는 API")
    public ResponseEntity<Page<BoardListResponseDTO>> getAllBoards(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<BoardListResponseDTO> boards = boardService.getAllBoards(pageable);
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    @Operation(summary = "게시글 상세 조회", description = "게시글의 ID 값으로 정보를 조회하는 API")
    public ResponseEntity<BoardResponseDTO> getBoardById(@PathVariable Long id) {
        BoardResponseDTO board = boardService.getBoardById(id);
        return ResponseEntity.ok(board);
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시글 수정", description = "특정 게시글을 수정하는 API")
    public ResponseEntity<BoardResponseDTO> updateBoard(@PathVariable Long id, @RequestBody BoardRequestDTO requestDTO) {
        BoardResponseDTO updatedBoard = boardService.updateBoard(id, requestDTO);
        return ResponseEntity.ok(updatedBoard);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "특정 게시글을 삭제하는 API - 삭제 여부로 판단")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @Operation(summary = "키워드로 게시글 검색", description = "지정된 키워드로 게시글을 검색하는 API")
    public ResponseEntity<Page<BoardResponseDTO>> searchBoardsByKeyword(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<BoardResponseDTO> resultPage = boardService.searchBoardsByKeyword(keyword, pageable);

        return ResponseEntity.ok(resultPage);
    }
    @GetMapping("/myBoards")
    @Operation(summary = "나의 게시글 조회", description = "현재 사용자가 작성한 게시글을 조회하는 API")
    public ResponseEntity<List<BoardResponseDTO>> getMyBoards(){
        List<BoardResponseDTO> boards = boardService.getMyBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("test");
      return   "test";
    };
}
