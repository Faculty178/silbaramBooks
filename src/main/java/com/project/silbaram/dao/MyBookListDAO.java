package com.project.silbaram.dao;


import com.project.silbaram.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyBookListDAO {

    // 전체조회
    BookVO getAllMyBooks();


}
