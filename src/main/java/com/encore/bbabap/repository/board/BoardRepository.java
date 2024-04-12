package com.encore.bbabap.repository.board;


import com.encore.bbabap.domain.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b FROM Board b LEFT JOIN FETCH b.comments WHERE b.id = :boardId")
    Optional<Board> findByIdWithComments(@Param("boardId") Long boardId);

//    Page<Board> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content, Pageable pageable);

    List<Board> findAllByDeletedYnFalse();

    Optional<Board> findByIdAndDeletedYnFalse(Long id);

    Page<Board> findAllByDeletedYnFalse(Pageable pageable);

    Page<Board> findByTitleContainingIgnoreCaseAndDeletedYnFalseOrContentContainingIgnoreCaseAndDeletedYnFalse(String title, String content, Pageable pageable);

//    @EntityGraph(attributePaths = "comments")
//    Optional<Board> findById(Long id);
}