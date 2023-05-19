package com.project.silbaram.service;


import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import com.project.silbaram.dto.MemberPassWordModifyDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    boolean addMember(MemberDTO memberDTO);

    Long login(String userId, String password);

    MemberDTO getByUuid(String uuid);

    void updateUuid(Long mid, String uuid);

    boolean isDuplicatedUserId(String userId);
    boolean isDuplicatedUserNickName(String nickName);

    MemberDTO getMemberByMid(Long mid);

//    String getPasswordByMid(Long mid);

    void modifyMember(MemberModifyDTO memberDTO);
//
    void modifyMemberPw(MemberPassWordModifyDTO memberDTO);



//    void updateUuid(String mid, String uuid);
//
//    MemberDTO getByUuid(String uuid);


}