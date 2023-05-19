package com.project.silbaram.service;


import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import com.project.silbaram.dto.MemberPassWordModifyDTO;
import com.project.silbaram.vo.MemberVO;
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

    boolean modifyMemberPwByEmailAndUserId (String password, String email, String userId);

    void modifyMember(MemberModifyDTO memberDTO);
//
    void modifyMemberPw(MemberPassWordModifyDTO memberDTO);

    MemberDTO getMemberByEmail(String email);



//    void updateUuid(String mid, String uuid);
//
//    MemberDTO getByUuid(String uuid);


}