package com.project.silbaram.service;

import com.project.silbaram.dto.BookDTO;

import java.util.List;

public interface BookService {

    void insertBook(BookDTO bookDTO);

    void updateBook(BookDTO bookDTO);

    void deleteBookById(Long bkid);

    BookDTO getBookById(Long bkid);

    List<BookDTO> getBookList();
}