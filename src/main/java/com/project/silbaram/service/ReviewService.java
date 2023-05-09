package com.project.silbaram.service;

import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.dto.ReviewDTO;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    void register(ReviewDTO reviewDTO);

    ReviewDTO readOne(int rid);

    void modify(ReviewDTO reviewDTO);

    void remove(int rid);

    PageResponseDTO<ReviewDTO> list(PageRequestDTO pageRequestDTO);

}
