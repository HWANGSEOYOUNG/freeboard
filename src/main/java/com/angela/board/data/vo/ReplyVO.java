package com.angela.board.data.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReplyVO {
    private Long id;
    private String reContent;
    private String reCreateDate;

    private ArticleVO articleVO;
}
