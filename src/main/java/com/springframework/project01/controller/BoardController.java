package com.springframework.project01.controller;

import com.springframework.project01.dto.BoardDTO;
import com.springframework.project01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        int saveResult = boardService.save(boardDTO);
        if (saveResult > 0) {
            // 성공하면 리스트페이지로 이동
            return "redirect:/board/";
        } else {
            // 실패하면 해당 페이지에 머무름
            return "save";
        }
    }

    @GetMapping("/")
    //DB에서 무언가를 가져온다면 매개변수에 Model이 필요하다.
    public String findAll(Model model){
        // 서비스에서 DB를 가져와서 List 객체로 담고 model객체에 넣어서 화면으로 출력.
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        // 여기서 board로 보내줘서 jsp에서 board로 받아서 사용.
        model.addAttribute("board", boardDTO);
        return "detail";

    }
}
