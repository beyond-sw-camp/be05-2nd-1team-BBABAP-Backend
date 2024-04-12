package com.encore.bbabap.service.board;


import com.encore.bbabap.api.board.request.BoardRequestDTO;
import com.encore.bbabap.api.board.response.BoardListResponseDTO;
import com.encore.bbabap.api.board.response.BoardResponseDTO;
import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import com.encore.bbabap.config.SecurityUtils;
import com.encore.bbabap.domain.board.Board;
import com.encore.bbabap.domain.comment.Comment;
import com.encore.bbabap.domain.user.User;
import com.encore.bbabap.repository.Comment.CommentRepository;
import com.encore.bbabap.repository.board.BoardRepository;
import com.encore.bbabap.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public BoardResponseDTO createBoard(BoardRequestDTO requestDTO) {

        // 현재 사용자의 이메일 가져오기
        String userEmail = SecurityUtils.getCurrentUserEmail();
        System.out.println("현재 로그인한 사용자의 이메일: " + userEmail);

        // 이메일을 사용하여 사용자 정보 가져오기
        User user = userRepository.findByEmail(userEmail);
        System.out.println(user);

        Board board = Board.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .user(user)
                .registeredAt(LocalDateTime.now())
                .deletedYn(false)
                .build();
        Board savedBoard = boardRepository.save(board);

        return convertToDTO(savedBoard);
    }

    @Transactional(readOnly = true)
    public Page<BoardListResponseDTO> getAllBoards(Pageable pageable) {
        Page<Board> boards = boardRepository.findAllByDeletedYnFalse(pageable);
        return boards.map(this::convertToBoardDTO);
    }


    @Transactional(readOnly = true)
    public BoardResponseDTO getBoardById(Long id) {
        Board board = boardRepository.findByIdWithComments(id).orElse(null);
        if (board != null && board.getDeletedYn()) { // 삭제된 게시물인 경우
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board with id " + id + " is deleted"); // 삭제된 게시물인 경우
        }
        else if(board==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found with id: " + id); // 없는 게시물인 경우
        }

        List<Comment> comments = commentRepository.findAllByBoardId(id);
        comments.removeIf(Comment::getDeletedYn);

        return convertToDTO(board);
    }

    @Transactional(readOnly = true)
    public Page<BoardResponseDTO> searchBoardsByKeyword(String keyword, Pageable pageable) {
        // 제목(title) 또는 내용(contents)에서 키워드를 포함하는 게시물을 검색
        Page<Board> boards = boardRepository.findByTitleContainingIgnoreCaseAndDeletedYnFalseOrContentContainingIgnoreCaseAndDeletedYnFalse(keyword, keyword, pageable);

        // 검색 결과를 BoardResponseDTO로 변환
        return boards.map(this::convertToDTO);
    }

    @Transactional
    public BoardResponseDTO updateBoard(Long id, BoardRequestDTO requestDTO) {

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));
        if (board != null && board.getDeletedYn()) { // 삭제된 게시물인 경우
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board with id " + id + " is deleted"); // 삭제된 게시물인 경우
        }

        // 현재 사용자의 이메일 가져오기
        String currentUserEmail = SecurityUtils.getCurrentUserEmail();
        System.out.println(currentUserEmail);

        // 게시물을 작성한 사용자의 이메일 가져오기
        String authorEmail = board.getUser().getEmail();
        System.out.println(authorEmail);

        // 현재 사용자와 게시물 작성자의 이메일이 일치하는지 확인
        if (!currentUserEmail.equals(authorEmail)) {
            throw new RuntimeException("You do not have permission to update this board.");
        }

        board.updateContent(requestDTO.getTitle(), requestDTO.getContent(), LocalDateTime.now());

        return convertToDTO(board);
    }

//    @Transactional
//    public void deleteBoard(Long id) {
//        boardRepository.deleteById(id);
//    }

    @Transactional
    public void deleteBoard(Long id) {

        String currentUserEmail = SecurityUtils.getCurrentUserEmail(); // 사용자의 이메일 가져오기

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + id));

        // 보드를 작성한 사용자의 이메일과 현재 사용자의 이메일을 비교하여 권한 확인
        if (!board.getUser().getEmail().equals(currentUserEmail)) {
            throw new RuntimeException("You do not have permission to delete this board.");
        }

        if (board.getDeletedYn()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Board with id " + id + " is already deleted");
        }

        board.deleteContent(true, LocalDateTime.now());

        boardRepository.save(board);

        // 실제로 데이터를 삭제하는 경우
        // boardRepository.delete(board);
    }

    @Transactional
    public List<BoardResponseDTO> getMyBoards() {
        // 현재 사용자의 이메일 가져오기
        String userEmail = SecurityUtils.getCurrentUserEmail();
        System.out.println("현재 로그인한 사용자의 이메일: " + userEmail);

        // 이메일을 사용하여 사용자 정보 가져오기
        User user = userRepository.findByEmail(userEmail);
        System.out.println(user);

        List<Board> boards = boardRepository.findAll();

        List<BoardResponseDTO> list = new ArrayList<>();
        for(Board board : boards){
            if(board.getUser().getEmail().equals(userEmail) && !board.getDeletedYn()){
                BoardResponseDTO dto = convertToDTO(board);
                list.add(dto);
            }
        }

        return list;
    }

    private BoardListResponseDTO convertToBoardDTO(Board board) {
        return BoardListResponseDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .nickname(board.getUser().getNickname())
                .registeredAt(board.getRegisteredAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }

    private BoardResponseDTO convertToDTO(Board board) {
        List<CommentResponseDTO> commentDTOs = board.getComments().stream()
                .filter(comment -> !comment.getDeletedYn())
                .map(comment -> CommentResponseDTO.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .createdAt(comment.getCreatedAt())
                        .nickname(comment.getUser().getNickname())
                        .boardId(comment.getBoard().getId())
                        .build())
                .collect(Collectors.toList());

        return BoardResponseDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .nickname(board.getUser().getNickname())
                .registeredAt(board.getRegisteredAt())
                .updatedAt(board.getUpdatedAt())
                .comments(commentDTOs)
                .build();
    }
}
