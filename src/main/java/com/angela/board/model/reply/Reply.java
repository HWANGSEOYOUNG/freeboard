package com.angela.board.model.reply;

import com.angela.board.model.article.Article;
import com.angela.board.model.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString(exclude = "article")
public class Reply extends BaseEntity<Long> {

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Article article;

    private String reContent;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime reCreateDate;
}
