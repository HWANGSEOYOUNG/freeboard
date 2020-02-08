package com.angela.board.service;


import com.angela.board.data.dto.ArticleDTO;
import com.angela.board.data.dto.ArticleUpdateDTO;
import com.angela.board.data.vo.ArticleVO;
import com.angela.board.model.article.Article;
import com.angela.board.model.board.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleService {

    Optional<Article> getArticle(Long id);

    boolean createArticle(ArticleDTO article);

    List<ArticleVO> findArticlesBoardGroup(Board board);

    ArticleVO getArticleById(Long id);

    Article entityArticleById(Long id);

    boolean updateArticle(ArticleUpdateDTO article);

    boolean deleteArticle(Long id);

}
