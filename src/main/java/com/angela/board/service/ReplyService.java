package com.angela.board.service;

import com.angela.board.data.dto.ReplyDTO;
import com.angela.board.data.vo.ReplyVO;
import com.angela.board.model.article.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {

    boolean addReply(ReplyDTO reply);

    List<ReplyVO> findReplyListArticleGroup(Article article);

    boolean deleteReply(Long id);
}
