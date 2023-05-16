package com.project.silbaram.dao;

import com.project.silbaram.dto.PageRequestDTO;
import com.project.silbaram.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewDAO {
    String getNow();

    void insert(ReviewVO reviewVO);

    //ReviewDAO 인터페이스에 가장 최근에 등록된 ReviewVO 우선적으로 나올 수 있도록 selectAll
    List<ReviewVO> selectAll();

    ReviewVO selectOne(int bdid);
    //ReviewVO 반환하도록

    void delete(int bdid);

    void update(ReviewVO reviewVO);

    List<ReviewVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
