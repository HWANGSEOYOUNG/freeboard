package com.angela.board.service;


import com.angela.board.data.dto.ArticleDTO;
import com.angela.board.data.vo.ArticleVO;
import com.angela.board.model.board.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {

    boolean createArticle(String boardName, ArticleDTO article);

    List<ArticleVO> findArticlesBoardGroup(Board board);

    ArticleVO getArticleById(Long id);

    boolean updateArticle(Long id, ArticleDTO article);

    boolean deleteArticle(Long id);

}
