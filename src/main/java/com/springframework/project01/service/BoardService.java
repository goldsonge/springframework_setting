package com.springframework.project01.service;

import com.springframework.project01.dto.BoardDTO;
import com.springframework.project01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public int save(BoardDTO boardDTO){
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO findById(Long id){
        return boardRepository.findById(id);
    }
}
