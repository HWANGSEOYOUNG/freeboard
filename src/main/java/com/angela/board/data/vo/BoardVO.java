package com.angela.board.data.vo;

import com.angela.board.model.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardVO {
    private String name;

    public BoardVO(Board b) {
        if(b != null){
            this.name = b.getName();
        }
    }
}
