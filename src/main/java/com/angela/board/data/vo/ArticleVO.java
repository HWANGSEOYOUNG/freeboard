package com.angela.board.data.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArticleVO {

    private String title;
    private String content;
    private String createDate;

    private BoardVO boardVO;

}
