package com.project.silbaram.service;

import com.project.silbaram.dao.BookDAO;
import com.project.silbaram.dto.*;
import com.project.silbaram.vo.BookVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService{

    private final BookDAO bookDAO;
    //ModelMapper - dto를 vo로 변환
    private final ModelMapper modelMapper;


    @Override
    public BookDTO readOne(int bkid) {
        BookVO bookVO = bookDAO.selectOne(bkid);
        BookDTO bookDTO = modelMapper.map(bookVO, BookDTO.class);
        //vo로 받아서 DTO로 전달

        return bookDTO;
    }



    @Override
    public PageResponseDTO<BookDTO> list(PageRequestDTO pageRequestDTO) {
        List<BookVO> voList = bookDAO.selectList(pageRequestDTO);

        List<BookDTO> dtoList = new ArrayList<>();
        for (BookVO bookVO : voList) {
            dtoList.add(modelMapper.map(bookVO, BookDTO.class));
        }
        int total = bookDAO.getCount(pageRequestDTO);

        PageResponseDTO<BookDTO> pageResponseDTO = PageResponseDTO.<BookDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }
}
