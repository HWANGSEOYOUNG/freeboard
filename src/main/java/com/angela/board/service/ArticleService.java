package com.angela.board.service;

import com.angela.board.entity.Article;
import com.angela.board.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public Article createArticle(Article article){
        return articleRepository.save(article);
    }

    @Transactional
    public List<Article> listOfArticle(){
        return articleRepository.findAll();
    }

    @Transactional
    public Optional<Article> itemArticle(long id){
        return articleRepository.findById(id);
    }


}
