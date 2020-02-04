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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardService boardService;

    @Override
    public boolean createArticle(String boardName, ArticleDTO article) {
        Article saved = new Article();

        saved.setBoard(boardService.entityBoardByName(boardName));
        if (saved.getBoard() != null) {
            saved.setTitle(article.getTitle());
            saved.setContent(article.getContent());
            Article result = articleRepository.save(saved);

            return !ObjectUtils.isEmpty(result);
        } else {
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

    //@Transactional
    @Override
    public ArticleVO getArticleById(Long id) {
        BooleanBuilder builder = new BooleanBuilder();
        QArticle qArticle = QArticle.article;
        builder.and(qArticle.id.eq(id));
        Optional<Article> getArticle = articleRepository.findOne(builder);

        if (!getArticle.isEmpty()) {
            ArticleVO articleVO = ArticleVO.builder()
                    .title(getArticle.get().getTitle())
                    .content(getArticle.get().getContent())
                    .boardVO(boardService.getBoardByName(getArticle.get().getBoard().getName()))
                    .build();
            return articleVO;
        } else {
            return null;
        }

    }

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
