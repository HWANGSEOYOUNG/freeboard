package com.angela.board.api;

import com.angela.board.data.dto.BoardDTO;
import com.angela.board.data.dto.BoardUpdateDTO;
import com.angela.board.data.vo.BoardVO;
import com.angela.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class BoardApi {

    private final BoardService boardService;

    @PostMapping("/add")
    public boolean create(BoardDTO param) {
        return boardService.addBoard(param);
    }

    @GetMapping("/list")
    public List<BoardVO> listAll() {
        return boardService.getBoardList();
    }

    @PutMapping("/modify")
    public boolean update(BoardUpdateDTO param) {
        return boardService.updateBoard(param);
    }

    @DeleteMapping("/del")
    public boolean delete(String name) {
        return boardService.deleteBoard(name);
    }

}

