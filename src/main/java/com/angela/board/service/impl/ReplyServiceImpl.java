package com.angela.board.service.impl;

import com.angela.board.data.dto.ReplyDTO;
import com.angela.board.data.vo.ReplyVO;
import com.angela.board.model.article.Article;
import com.angela.board.model.reply.QReply;
import com.angela.board.model.reply.Reply;
import com.angela.board.model.reply.predicate.ReplyPredicate;
import com.angela.board.model.reply.repository.ReplyRepository;
import com.angela.board.service.ArticleService;
import com.angela.board.service.ReplyService;
import com.google.common.collect.Lists;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final ArticleService articleService;

    @Override
    public boolean addReply(ReplyDTO reply) {
        if(reply.getReContent() == null || reply.getReContent().length() == 0){
            return false;
        }

        Reply saved = new Reply();
        saved.setArticle(articleService.entityArticleById(reply.getArticleId()));
        if (saved.getArticle() != null) {
            saved.setReContent(reply.getReContent());
            saved.setReCreateDate(LocalDateTime.now());
            Reply result = replyRepository.save(saved);

            return !ObjectUtils.isEmpty(result);
        } else {
            return false;
        }
    }

    @Override
    public List<ReplyVO> findReplyListArticleGroup(Article article) {
        return setReplyVOs(replyRepository.findAll(ReplyPredicate.eqArticle(article)));
    }

    private List<ReplyVO> setReplyVOs(Iterable<Reply> replies){
        List<ReplyVO> results = Lists.newArrayList();

        replies.forEach(reply -> {
            ReplyVO re = ReplyVO.builder()
                    .id(reply.getId())
                    .reContent(reply.getReContent())
                    .reCreateDate(reply.getReCreateDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                    .articleVO(articleService.getArticleById(reply.getArticle().getId()))
                    .build();

            results.add(re);
        });
        return results;
    }

    @Override
    public boolean deleteReply(Long id) {
        BooleanBuilder builder = new BooleanBuilder();
        QReply qReply = QReply.reply;
        builder.and(qReply.id.eq(id));

        AtomicBoolean result = new AtomicBoolean(false);
        replyRepository.findOne(builder).ifPresent(reply -> {
            replyRepository.delete(reply);
            result.set(true);
        });
        return result.get();
    }
}
