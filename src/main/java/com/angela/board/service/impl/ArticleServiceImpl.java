package com.angela.board.service.impl;

import com.angela.board.data.dto.ArticleDTO;
import com.angela.board.data.vo.ArticleVO;
import com.angela.board.model.article.Article;
import com.angela.board.model.article.QArticle;
import com.angela.board.model.article.predicate.ArticlePredicate;
import com.angela.board.model.article.repository.ArticleRepository;
import com.angela.board.model.board.Board;
import com.angela.board.service.ArticleService;
import com.angela.board.service.BoardService;
import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardService boardService;

    @Override
    public boolean createArticle(String boardName, ArticleDTO article) {
        Article saved = new Article();

        saved.setBoard(boardService.entityBoardByName(boardName));
        if(saved.getBoard() != null){
            saved.setTitle(article.getTitle());
            saved.setContent(article.getContent());
            Article result = articleRepository.save(saved);

            return !ObjectUtils.isEmpty(result);
        }else {
            return false;
        }
    }

    @Override
    public List<ArticleVO> findArticlesBoardGroup(Board board) {
        return setArticleVOs(articleRepository.findAll(ArticlePredicate.eqBoard(board)));
    }

    private List<ArticleVO> setArticleVOs(Iterable<Article> articles) {
        List<ArticleVO> results = Lists.newArrayList();

        articles.forEach(article -> {
            ArticleVO art = ArticleVO.builder()
                    .title(article.getTitle())
                    .content(article.getContent())
                    .boardVO(boardService.getBoardByName(article.getBoard().getName()))
                    .build();

            results.add(art);
        });

        return results;
    }

//    @Override
//    public ArticleVO getArticleById(Long id) {
//        Optional<Article> getArticle = articleRepository.findById(id);
//
//        ArticleVO articleVO = new ArticleVO();
//
//        return null;
//    }

    @Override
    public boolean updateArticle(Long id, ArticleDTO article) {
        BooleanBuilder builder = new BooleanBuilder();
        QArticle qArticle = QArticle.article;
        builder.and(qArticle.id.eq(id));

        AtomicBoolean result = new AtomicBoolean(false);
        articleRepository.findOne(builder).ifPresent(art -> {
            art.setTitle(article.getTitle());
            art.setContent(article.getContent());
            articleRepository.save(art);
            result.set(true);
        });
        return result.get();
    }

    @Override
    public boolean deleteArticle(Long id) {
        BooleanBuilder builder = new BooleanBuilder();
        QArticle qArticle = QArticle.article;
        builder.and(qArticle.id.eq(id));

        AtomicBoolean result = new AtomicBoolean(false);
        articleRepository.findOne(builder).ifPresent(article -> {
            articleRepository.delete(article);
            result.set(true);
        });
        return result.get();
    }
}
