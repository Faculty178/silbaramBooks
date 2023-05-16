package com.project.silbaram.service;


import com.project.silbaram.dao.MemberDAO;
import com.project.silbaram.dto.MemberDTO;
import com.project.silbaram.dto.MemberModifyDTO;
import com.project.silbaram.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;


    @Override
    public boolean addMember(MemberDTO memberDTO) {
        log.info(modelMapper);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.insertMember(memberVO);
        log.info(memberVO);
        return true;
    }

    @Override
    public boolean isDuplicatedUserId(String userId) {
        int count = memberDAO.countMemberByUserId(userId);
        return count > 0; // true == 중복, false면 사용가능한 아이디
    }

    @Override
    public boolean isDuplicatedUserNickName(String nickName) {
        int count = memberDAO.countMemberByUserNickName(nickName);
        return count > 0; // true == 중복, false면 사용가능한 닉네임
    }

    @Override
    public MemberDTO getMemberByMid(Long mid) {
        MemberVO memberVO = memberDAO.selectMemberByMid(mid);
        if (memberVO == null) {
            return null;
        }
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        return memberDTO;
    }

    @Override
    public void modifyMember(MemberModifyDTO memberDTO) {
        log.info(modelMapper);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.updateMember(memberVO);
        log.info(memberVO);
    }

    @Override
    public void modifyMemberPw(MemberModifyDTO memberDTO) {
        log.info(modelMapper);
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.updatePassword(memberVO);
        log.info(memberVO);
    }

    @Override
    public Long login(String userId, String password) {
        MemberVO memberVO = memberDAO.selectMemberById(userId);
        if (memberVO == null) {
            return null;
        }
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);
        if(memberDTO.getPassword().equals(password)) {
            return memberDTO.getMid();
        }
        return null;
    }






}