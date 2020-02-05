package com.angela.board.model.reply.predicate;

import com.angela.board.model.article.Article;
import com.angela.board.model.reply.QReply;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class ReplyPredicate {

    private static final QReply qReply = QReply.reply;

    public static Predicate eqArticle(final Article article){
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qReply.isActive.isTrue().and(qReply.isDeleted.isFalse()));

        if(article != null){
            builder.and(qReply.article.eq(article));
        }else {
            builder.and(qReply.article.isNull());
        }

        return builder;
    }
}
