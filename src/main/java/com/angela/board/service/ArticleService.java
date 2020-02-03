package com.angela.board.service;


import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    boolean createArticle();

    boolean deleteArticle();

}
