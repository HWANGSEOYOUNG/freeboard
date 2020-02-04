package com.angela.board.api;

import com.angela.board.data.dto.ArticleDTO;
import com.angela.board.data.vo.ArticleVO;
import com.angela.board.model.board.Board;
import com.angela.board.service.ArticleService;
import com.angela.board.service.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class ArticleApi {

    private final ArticleService articleService;
    private final BoardService boardService;

    @PostMapping("/write")
    public boolean create(@RequestParam String boardName, ArticleDTO article){
        return articleService.createArticle(boardName,article);
    }

    //전체 게시글 읽기
    @GetMapping("/list")
    public List<ArticleVO> list(@RequestParam String boardName){
        Optional<Board> board = boardService.getBoard(boardName);

        if(board.isEmpty()) return null;

        return articleService.findArticlesBoardGroup(board.get());
    }

    //선택한 게시글 읽기
    @GetMapping("/article")
    public boolean retrieve(@RequestParam Long id){
        return  true;
    }

    @PutMapping("/modify")
    public boolean update(@RequestParam Long id, ArticleDTO article){
        return articleService.updateArticle(id,article);
    }

    @DeleteMapping("/del")
    public boolean delete(@RequestParam Long id){
        return articleService.deleteArticle(id);
    }

}
