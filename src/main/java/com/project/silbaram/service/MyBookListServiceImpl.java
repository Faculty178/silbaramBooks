package com.project.silbaram.service;

import com.project.silbaram.dao.MyBookListDAO;
import com.project.silbaram.dto.OrderListDTO;
import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.dto.PageResponseDTO;
import com.project.silbaram.vo.OrderListVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class MyBookListServiceImpl implements MyBookListService {

    private final MyBookListDAO myBookListDAO;
    private final ModelMapper modelMapper;

//    @Override
//    public PageResponseDTO<OrderListDTO> getAllMyBooks(PageRequestDTO pageRequestDTO) {
//        return null;
//    }


    @Override
    public PageResponseDTO<OrderListDTO> getAllMyBooks(Long memberId,PageRequestDTO pageRequestDTO) {
        List<OrderListVO> voList = myBookListDAO.selectAllMyBooks(memberId);
        log.info(voList);
        List<OrderListDTO> dtoList = new ArrayList<>();
        for (OrderListVO orderListVO: voList
             ) {
            dtoList.add(modelMapper.map(orderListVO, OrderListDTO.class)); // vo를 dto로 mapping
        }
        // 전체 갯수
        int total = myBookListDAO.getCount(pageRequestDTO);

        PageResponseDTO<OrderListDTO> pageResponseDTO = PageResponseDTO.<OrderListDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }
//
//    @Override
//    public List<OrderListDTO> getAllMyBooksBySpellASC(Long memberId) {
//        List<OrderListVO> orderListVOList = myBookListDAO.selectAllMyBooksBySpellASC(memberId);
//        return orderListVOList.stream()
//                .map(orderListVO -> modelMapper.map(orderListVO, OrderListDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<OrderListDTO> getOrderByMemberAndKeyword(long memberId, String keyword) {
//        List<OrderListVO> orderListVOList = myBookListDAO.selectOrderByMemberAndKeyword(memberId, keyword);
//        return orderListVOList.stream()
//                .map(orderListVO -> modelMapper.map(orderListVO, OrderListDTO.class))
//                .collect(Collectors.toList());
//    }
}

