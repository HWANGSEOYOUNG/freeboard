package com.angela.board.controller;

import com.angela.board.entity.Board;
import com.angela.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 생성
    public Board create(@RequestBody Board board){
     return boardService.createBoard(board);
    }

    //게시판 가져오기
    public List<Board> listAll(){
        return boardService.listOfBoard();
    }

    //게시판 수정
    public int update(String name){
        return boardService.updateBoard(name);
    }

    //게시판 삭제
    public Board delete(long boardId){

        Board deleteBoard = new Board();
        deleteBoard.setBoardId(boardId);
        return deleteBoard;
    }
}

