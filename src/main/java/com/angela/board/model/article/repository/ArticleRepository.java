package com.angela.board.model.article.repository;

import com.angela.board.model.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long>, QuerydslPredicateExecutor<Article> {
}
