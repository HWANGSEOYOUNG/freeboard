package com.angela.board.service;

import com.angela.board.data.dto.BoardDTO;
import com.angela.board.data.dto.BoardUpdateDTO;
import com.angela.board.data.vo.BoardVO;
import com.angela.board.model.board.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BoardService {

    Optional<Board> getBoard(String boardName);

    BoardVO getBoardByName(String boardName);

    Board entityBoardByName(String boardName);

    List<BoardVO> getBoardList();

    boolean addBoard(BoardDTO param);

    boolean updateBoard(BoardUpdateDTO param);

    boolean deleteBoard(String name);

}
