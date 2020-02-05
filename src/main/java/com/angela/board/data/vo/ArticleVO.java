package com.angela.board.data.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ArticleVO {
    private Long id;
    private String title;
    private String content;
    private String createDate;
    private String updateDate;

    private BoardVO boardVO;

}
