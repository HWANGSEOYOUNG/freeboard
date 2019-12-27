package com.angela.board.controller;

import com.angela.board.entity.Article;
import com.angela.board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/board")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

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
