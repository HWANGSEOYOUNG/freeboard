package com.angela.board.model.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<PK> {

    @Id
    @GeneratedValue //(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private PK id; // PK

    @Column(insertable = false)
    @ColumnDefault("true")
    private boolean isActive = true;  // 사용여부

    @Column(insertable = false)
    @ColumnDefault("false")
    private boolean isDeleted = false; // 삭제여부

    @Version
    @JsonIgnore
    private Long version;
}
