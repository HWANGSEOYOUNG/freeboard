package com.angela.board.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateDTO {

    private Long id;
    private String title;
    private String content;
}
