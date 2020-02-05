package com.angela.board.data.vo;

import com.angela.board.model.board.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
    private Long id;
    private String name;

    public BoardVO(Board b) {
        if(b != null){
            this.id = b.getId();
            this.name = b.getName();
        }
    }
}
