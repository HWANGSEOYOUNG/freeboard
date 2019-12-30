package com.angela.board.repository;

import com.angela.board.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findAllByBoard_BoardId(long boardId);
}
