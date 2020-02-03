package com.angela.board.model.board;

import com.angela.board.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

//게시판
@Getter
@Setter
@Entity
public class Board extends BaseEntity<Long> {

    private String name;
}
