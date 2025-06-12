package com.edu.springboot.jdbc;

import java.util.List;

import org.springframework.stereotype.Service;

//DAO의 부모 역할을 함
@Service
public interface IMemberService
{
	// 추상 매서드가 있어야 함
	public int insert(MemberDTO memberDTO); // 회원정보추가
	public List<MemberDTO> select(); // 회원목록
	public MemberDTO selectOne(MemberDTO memberDTO);
	public int update(MemberDTO memberDTO);
	public int delete(MemberDTO memberDTO);
}
