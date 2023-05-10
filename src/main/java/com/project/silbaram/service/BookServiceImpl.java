package com.project.silbaram.service;

import com.project.silbaram.dao.BookDAO;
import com.project.silbaram.dto.BookDTO;
import com.project.silbaram.vo.BookVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final ModelMapper modelMapper;

    @Override
    public void insertBook(BookDTO bookDTO) {
        log.info(modelMapper);
        BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);
        bookDAO.insertBook(bookVO);
        log.info(bookVO);
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);
        bookDAO.updateBook(bookVO);
        log.info(bookVO);
    }

    public BookDTO getBookById(Long id) {
        BookVO bookVO = bookDAO.getBookById(id);
        return modelMapper.map(bookVO, BookDTO.class);
    }

    @Override
    public List<BookDTO> getBookList() {
        List<BookVO> bookVOList = bookDAO.getBookList();
        return bookVOList.stream()
                .map(bookVO -> modelMapper.map(bookVO, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBookById(Long bkid) {
        bookDAO.deleteBookById(bkid);
    }

}