package com.angela.board.repository;

import com.angela.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    // 게시판 이름 수정 쿼리
}
