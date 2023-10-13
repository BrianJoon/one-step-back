package com.app.onestepback.mapper;

import com.app.onestepback.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.lang.reflect.Member;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    //    회원가입 - 이메일
    public void insert(MemberVO memberVO);

    //    카카오 계정 추가 - 로그인
    public void insertKakao(MemberVO memberVO);

    //    계정정보 조회
    public MemberVO selectById(Long id);

    //    카카오 계정 이메일로 조회 - 로그인
    public Optional<MemberVO> selectByEmail(String memberEmail);

    //    유저 복귀(MEMBER_STATUS = 'ACTIVE')
    public void updateToActive(Long id);

    //    유저 계정 삭제(MEMBER_STATUS = 'DISABLED')
    public void updateToDelete(Long id);
}