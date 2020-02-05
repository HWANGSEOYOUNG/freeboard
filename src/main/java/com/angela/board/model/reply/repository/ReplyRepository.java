package com.angela.board.model.reply.repository;

import com.angela.board.model.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long>, QuerydslPredicateExecutor<Reply> {
}
