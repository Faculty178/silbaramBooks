package com.project.silbaram.service;

import com.project.silbaram.dto.BookDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    BookDTO readOne(int bkid);

    PageResponseDTO<BookDTO> list(PageRequestDTO pageRequestDTO);


}
