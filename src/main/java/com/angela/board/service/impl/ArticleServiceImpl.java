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
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            saved.setCreateDate(LocalDateTime.now());
            Article result = articleRepository.save(saved);

            return !ObjectUtils.isEmpty(result);
        } else {
            return false;
        }
    }

    @Override
    public Optional<Article> getArticle(Long id) {
        Article article = new Article();
        article.setId(id);
        Example<Article> e = Example.of(article);

        return articleRepository.findOne(e);
    }

    @Override
    public List<ArticleVO> findArticlesBoardGroup(Board board) {
        return setArticleVOs(articleRepository.findAll(ArticlePredicate.eqBoard(board)));
    }

    private List<ArticleVO> setArticleVOs(Iterable<Article> articles) {
        List<ArticleVO> results = Lists.newArrayList();

        articles.forEach(article -> {
            ArticleVO art = ArticleVO.builder()
                    .id(article.getId())
                    .title(article.getTitle())
                    .content(article.getContent())
                    .createDate(article.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                    .updateDate(article.getUpdateDate() == null ? null : article.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                    .boardVO(boardService.getBoardByName(article.getBoard().getName()))
                    .build();

            results.add(art);
        });

        return results;
    }

    //@Transactional
    @Override
    public ArticleVO getArticleById(Long id) {
        Article getArticle = entityArticleById(id);

        if (getArticle != null) {
            ArticleVO articleVO = ArticleVO.builder()
                    .id(getArticle.getId())
                    .title(getArticle.getTitle())
                    .content(getArticle.getContent())
                    .createDate(getArticle.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                    .updateDate(getArticle.getUpdateDate() == null ? null : getArticle.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                    .boardVO(boardService.getBoardByName(getArticle.getBoard().getName()))
                    .build();
            return articleVO;
        } else {
            return null;
        }

    }

    @Override
    public Article entityArticleById(Long id){
        BooleanBuilder builder = new BooleanBuilder();
        QArticle qArticle = QArticle.article;
        builder.and(qArticle.id.eq(id));
        Optional<Article> getArticle = articleRepository.findOne(builder);

        return getArticle.orElse(null);
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
            art.setUpdateDate(LocalDateTime.now());
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
