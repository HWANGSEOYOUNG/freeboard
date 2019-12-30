package com.angela.board.controller;

import com.angela.board.entity.Article;
import com.angela.board.service.ArticleService;
import com.angela.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequiredArgsConstructor //final, @NonNull인 필드값만 생성자 자동 생성
@RequestMapping("/board")
public class ArticleController {

    private final ArticleService articleService;

    private final BoardService boardService;

    //게시글 생성
    @RequestMapping(path = "/{boardId}/write", method = RequestMethod.POST)
    public Article create(@PathVariable("boardId") long boardId, @RequestBody Article article){

        article.setBoard(boardService.selectBoardId(boardId));
        return articleService.createArticle(article);
    }

    //전체 게시글 읽기
    @RequestMapping(path = "/{boardId}/list", method = RequestMethod.GET)
    public List<Article> listAll(@PathVariable("boardId")long boardId){
        return articleService.listOfArticle(boardId);
    }

    //선택한 게시글 읽기
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Article retrieve(@PathVariable("id") long id){
        return articleService.itemArticle(id).get();
    }

    //게시글 수정
    @RequestMapping(path = "/{id}/modify", method = RequestMethod.PATCH)
    public int update(){

        return 0;
    }

    //게시글 삭제
    @RequestMapping(path = "/{id}/del", method = RequestMethod.DELETE)
    public Article delete(@PathVariable("id")long id){

        articleService.deleteArticle(id);

        Article deleteArticle = new Article();
        deleteArticle.setId(id);

        return deleteArticle;
    }

}
