package com.project.silbaram.service;


import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    boolean addMember(MemberDTO memberDTO);

    Long login(String userId, String password);

    boolean isDuplicatedUserId(String userId);
    boolean isDuplicatedUserNickName(String nickName);

    public MemberDTO getMemberByMid(Long mid);

    void modifyMember(MemberModifyDTO memberDTO);

//    void updateUuid(String mid, String uuid);
//
//    MemberDTO getByUuid(String uuid);


}