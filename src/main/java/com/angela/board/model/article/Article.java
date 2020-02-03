package com.angela.board.model.article;

import com.angela.board.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import java.util.Date;

//게시글
@Getter
@Setter
@Entity
public class Article extends BaseEntity<Long> {

    //제목
    private String title;

    //내용
    private String content;

    //작성일
    @CreationTimestamp
    private Date createDate;

    //게시글의 소속 게시판
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name= "id_board")
//    private Board board;

}
