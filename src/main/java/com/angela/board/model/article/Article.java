package com.angela.board.model.article;

import com.angela.board.model.board.Board;
import com.angela.board.model.common.BaseEntity;
import com.angela.board.model.reply.Reply;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = "board")
public class Article extends BaseEntity<Long> {
    private String title;
    private String content;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    @ManyToOne
    @PrimaryKeyJoinColumn
    //@JsonBackReference
    private Board board;

    @OneToMany(orphanRemoval = true, mappedBy = "article")
    private List<Reply> replyList;

}
