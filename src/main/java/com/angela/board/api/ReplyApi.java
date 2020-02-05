package com.angela.board.api;

import com.angela.board.data.dto.ReplyDTO;
import com.angela.board.data.vo.ReplyVO;
import com.angela.board.model.article.Article;
import com.angela.board.service.ArticleService;
import com.angela.board.service.ReplyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyApi {

    private final ReplyService replyService;
    private final ArticleService articleService;

    @PostMapping("/add")
    public boolean add(@RequestParam Long articleId, ReplyDTO reply){
        return replyService.addReply(articleId,reply);
    }

    @GetMapping("/list")
    public List<ReplyVO> list(@RequestParam Long articleId){
        Optional<Article> article = articleService.getArticle(articleId);

        if(article.isEmpty()) return null;

        return replyService.findReplyListArticleGroup(article.get());
    }

    @DeleteMapping("/del")
    public boolean delete(@RequestParam Long id){
        return replyService.deleteReply(id);
    }

}
