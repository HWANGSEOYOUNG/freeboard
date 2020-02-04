package com.angela.board.model.board;

import com.angela.board.model.article.Article;
import com.angela.board.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Board extends BaseEntity<Long> {

    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "board")
    private List<Article> articles;
}
