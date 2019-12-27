package com.angela.board.controller;

import com.angela.board.entity.Article;
import com.angela.board.service.ArticleService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class ArticleController {

    private final ArticleService articleService;

    //게시글 생성
    @RequestMapping(path = "/{id}/write", method = RequestMethod.POST)
    public Article create(@PathVariable("id") Long id, @RequestBody Article article){

        return new Article();
    }

    //전체 게시글 읽기
    public List<Article> listAll(){

        List<Article> list = new ArrayList<>();
        return list;
    }

    //선택한 게시글 읽기
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Article retrieve(){

        return new Article();
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
