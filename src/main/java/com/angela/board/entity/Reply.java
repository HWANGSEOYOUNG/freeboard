package com.angela.board.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

//댓글
@Getter
@Setter
@Entity
public class Reply {

    //댓글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reId;

    //댓글의 부모 게시글 번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_article")
    private Article article;

    //댓글 내용
    @Column
    private String reContent;

    //작성일
    @Column
    @CreationTimestamp
    private Date reCreateDate;


}
