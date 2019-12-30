package com.angela.board.controller;

import com.angela.board.entity.Article;
import com.angela.board.service.ArticleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequiredArgsConstructor //final, @NonNull인 필드값만 생성자 자동 생성
@RequestMapping("/board")
public class ArticleController {

    private final ArticleService articleService;

    //게시글 생성
    @RequestMapping(path = "/write", method = RequestMethod.POST)
    public Article create(@RequestBody Article article){
        return articleService.createArticle(article);
    }

    //전체 게시글 읽기
    public List<Article> listAll(){
        return articleService.listOfArticle();
    }

    //선택한 게시글 읽기
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Optional<Article> retrieve(@PathVariable long id){
        return articleService.itemArticle(id);
    }

    //게시글 수정
    @RequestMapping(path = "/{id}/modify", method = RequestMethod.PUT)
    public int update(){

        return 0;
    }

    //게시글 삭제
    @RequestMapping(path = "/{id}/del", method = RequestMethod.DELETE)
    public Article delete(){

        return new Article();
    }

}
