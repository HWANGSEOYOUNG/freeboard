package com.angela.board.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//게시글
@Getter
@Setter
@Entity
public class Article implements Serializable {

    //게시번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //제목
    @Column
    private String title;

    //내용
    @Column
    private String content;

    //작성일
    @Column
    @CreationTimestamp
    private Date createDate;

    //게시글의 소속 게시판
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_board")
    private Board board;


}
