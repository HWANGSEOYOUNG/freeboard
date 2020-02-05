package com.angela.board.model.article.predicate;

import com.angela.board.model.article.QArticle;
import com.angela.board.model.board.Board;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class ArticlePredicate {

    private static final QArticle qArticle = QArticle.article;


    public static Predicate eqBoard(final Board board) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qArticle.isActive.isTrue().and(qArticle.isDeleted.isFalse()));

        if (board != null) {
            builder.and(qArticle.board.eq(board));
        } else {
            builder.and(qArticle.board.isNull());
        }

        return builder;
    }
}
