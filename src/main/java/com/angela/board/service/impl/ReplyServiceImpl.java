package com.angela.board.service.impl;

import com.angela.board.model.reply.repository.ReplyRepository;
import com.angela.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;



}
