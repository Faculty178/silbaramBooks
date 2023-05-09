package com.project.silbaram.service;

import com.project.silbaram.dto.BoardDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {

    void register(BoardDTO boardDTO);

    BoardDTO readOne(int bdid);

    void modify(BoardDTO boardDTO);

    void remove(int bdid);

//  목록/검색 기능
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

    String getNow();
}
