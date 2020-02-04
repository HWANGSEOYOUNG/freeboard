package com.angela.board.model.article;

import com.angela.board.model.board.Board;
import com.angela.board.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Article extends BaseEntity<Long> {
    private String title;
    private String content;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createDate;

    //게시글의 소속 게시판
    @ManyToOne
    @PrimaryKeyJoinColumn
    //@JsonBackReference
    private Board board;

}
