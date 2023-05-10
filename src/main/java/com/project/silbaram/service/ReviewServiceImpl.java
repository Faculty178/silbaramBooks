package com.project.silbaram.service;

import com.project.silbaram.dao.ReviewDAO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.dto.ReviewDTO;
import com.project.silbaram.vo.ReviewVO;
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
public class ReviewServiceImpl implements ReviewService{

    private final ReviewDAO reviewDAO;
    //ModelMapper - dto를 vo로 변환
    private final ModelMapper modelMapper;


    @Override
    public void register(ReviewDTO reviewDTO) {
        log.info(modelMapper);
        log.info("addReview...");

        ReviewVO reviewVO = modelMapper.map(reviewDTO, ReviewVO.class);

        log.info(reviewVO);

        reviewDAO.insert(reviewVO);
    }

    @Override
    public ReviewDTO readOne(int rid) {
        ReviewVO reviewVO = reviewDAO.selectOne(rid);
        ReviewDTO reviewDTO = modelMapper.map(reviewVO, ReviewDTO.class);
        //vo로 받아서 DTO로 전달

        return reviewDTO;
    }

    @Override
    public void modify(ReviewDTO reviewDTO) {
        ReviewVO reviewVO = modelMapper.map(reviewDTO, ReviewVO.class);
        log.info(reviewVO);
        reviewDAO.update(reviewVO);
    }

    @Override
    public void remove(int rid) {
        reviewDAO.delete(rid);
    }

    @Override
    public PageResponseDTO<ReviewDTO> list(PageRequestDTO pageRequestDTO) {
        List<ReviewVO> voList = reviewDAO.selectList(pageRequestDTO);

        List<ReviewDTO> dtoList = new ArrayList<>();
        for (ReviewVO reviewVO : voList) {
            dtoList.add(modelMapper.map(reviewVO, ReviewDTO.class));
        }
        int total = reviewDAO.getCount(pageRequestDTO);

        PageResponseDTO<ReviewDTO> pageResponseDTO = PageResponseDTO.<ReviewDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }





}
