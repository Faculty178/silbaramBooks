package com.project.silbaram.service;


import com.project.silbaram.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    boolean addMember(MemberDTO memberDTO);

    Long login(String userId, String password);

    boolean isDuplicatedUserId(String userId);

    void modifyMember(MemberDTO memberDTO);

//    void updateUuid(String mid, String uuid);
//
//    MemberDTO getByUuid(String uuid);


}