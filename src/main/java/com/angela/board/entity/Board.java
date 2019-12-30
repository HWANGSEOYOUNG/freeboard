package com.angela.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//게시판
@Getter
@Setter
@Entity
public class Board {

    //게시판 아이디
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardId;

    //게시판 이름
    @Column
    private String name;
}
