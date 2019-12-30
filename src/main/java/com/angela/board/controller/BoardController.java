package com.angela.board.controller;

import com.angela.board.entity.Board;
import com.angela.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 생성
    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public Board create(@RequestBody Board board){
     return boardService.createBoard(board);
    }

    //게시판 가져오기
    @RequestMapping(method = RequestMethod.GET)
    public List<Board> listAll(){
        return boardService.listOfBoard();
    }

    //게시판 수정
    @RequestMapping(path = "/{boardId}/modify", method = RequestMethod.PATCH)
    public int update(@PathVariable("boardId") long boardId, String name){
        return boardService.updateBoard(boardId, name);
    }

    //게시판 삭제
    @RequestMapping(path = "/{boardId}", method = RequestMethod.DELETE)
    public Board delete(@PathVariable("boardId") long boardId){

        boardService.deleteBoard(boardId);

        Board deleteBoard = new Board();
        deleteBoard.setBoardId(boardId);
        return deleteBoard;
    }
}

