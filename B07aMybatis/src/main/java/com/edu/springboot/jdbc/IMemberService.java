package com.edu.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMemberService
{
	// 추상 매서드가 있어야 함
	public List<MemberDTO> select(); // 회원목록
	public int insert(MemberDTO memberDTO); // 회원정보추가
	public MemberDTO selectOne(MemberDTO memberDTO);
	public int update(MemberDTO memberDTO);
	public int delete(MemberDTO memberDTO);
}
