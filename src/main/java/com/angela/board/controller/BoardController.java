package com.angela.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping({"/", ""})
    public String home(){
        return "view/index";
    }

    @GetMapping("/list")
    public String list(){
        return "board/list";
    }

    @GetMapping("/add")
    public String add(){
        return "board/add";
    }
}
