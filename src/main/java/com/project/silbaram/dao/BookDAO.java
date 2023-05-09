package com.project.silbaram.dao;

import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BookDAO {

    List<BookVO> list();

    BookVO selectOne(int bkid);

    List<BookVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);


}
