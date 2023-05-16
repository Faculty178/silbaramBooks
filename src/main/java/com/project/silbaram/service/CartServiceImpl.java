package com.project.silbaram.service;

import com.project.silbaram.dao.CartDAO;
import com.project.silbaram.dto.CartDTO;
import com.project.silbaram.vo.CartVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartDAO cartDAO; // 나를 위한 메모:todoMapper와 같은 것.
    private final ModelMapper modelMapper;

    @Override
    public void addCart(CartDTO cartDTO) { // 카트 추가
        log.info(modelMapper);
        CartVO cartVO = modelMapper.map(cartDTO, CartVO.class);
        cartDAO.insertCart(cartVO);
        log.info(cartVO);
    }

    @Override
    public List<CartDTO> getAll(Long mid) {
        List<CartVO> voList = cartDAO.selectAll(mid);
        List<CartDTO> dtoList = new ArrayList<>();
        for(CartVO cartVO : voList){
            CartDTO cartDTO = modelMapper.map(cartVO, CartDTO.class);
            dtoList.add(cartDTO);
        }
        return dtoList;
    }

    @Override
    public void remove(Long lkid) {
        cartDAO.delete(lkid);
    }

}
