package com.angela.board.data.dto;

import com.angela.board.data.vo.BoardVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {

    private String title;
    private String content;

    private BoardVO boardVO;
}
