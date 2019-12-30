package com.angela.board.repository;

import com.angela.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    // 게시판 이름 수정 쿼리
    @Modifying
    @Query(value = "UPDATE Board b SET b.name = :name WHERE b.boardId = :boardId")
    int updateBoardName(@Param("boardId") long boardId, @Param("name") String name);

    Board findByBoardId(long boardId);
}
