package com.project.silbaram.dao;

import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.BoardVO;
import com.project.silbaram.vo.BookVO;

import java.util.List;

public interface BookDAO {
    void insertBook(BookVO bookVO);
    void updateBook(BookVO bookVO);
    int deleteBookById(Long bkid);
    List<BookVO> getBookList();
    BookVO getBookById(Long bkid);



    List<BoardVO> selectAll();
    BookVO selectOne(int bkid);
    List<BookVO> list(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

}