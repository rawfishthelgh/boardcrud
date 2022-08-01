package com.spring.boardcrud.controller;

import com.spring.boardcrud.domain.entity.Board;
import com.spring.boardcrud.dto.BoardDto;
import com.spring.boardcrud.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String List(Model model,@RequestParam(value = "page", defaultValue = "1") Integer pageNum){
        List<BoardDto> boardDtoList = boardService.getBoardList(pageNum);
        Integer [] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList",boardDtoList);
        model.addAttribute("pageList",pageList);

        return "board/list.html";
    }

    @GetMapping("/post")
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto",boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        BoardDto boardDto =boardService.getPost(id);

        model.addAttribute("boardDto",boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}") //왜 PostMapping 아니라 PutMapping?
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long id){
        boardService.deletePost(id);

        return "redirect:/";
    }

    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList =boardService.searchPosts(keyword);
        model.addAttribute("boardList",boardDtoList);

        return "board/list.html";
    }
}
