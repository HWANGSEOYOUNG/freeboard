package com.angela.board.service;

import com.angela.board.data.dto.BoardDTO;
import com.angela.board.data.dto.BoardUpdateDTO;
import com.angela.board.data.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    List<BoardVO> getBoardList();

    boolean addBoard(BoardDTO param);

    boolean updateBoard(BoardUpdateDTO param);

    boolean deleteBoard(String name);

}
