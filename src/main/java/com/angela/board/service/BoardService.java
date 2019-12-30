package com.angela.board.service;

import com.angela.board.entity.Board;
import com.angela.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Board createBoard(Board board){
        return boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public List<Board> listOfBoard(){
        return boardRepository.findAll();
    }

    //borad name 수정
    @Transactional
    public int updateBoard(long boardId, String name){
        return boardRepository.updateBoardName(boardId, name);
    }

    @Transactional
    public void deleteBoard(long boardId){
        boardRepository.deleteById(boardId);
    }
}
