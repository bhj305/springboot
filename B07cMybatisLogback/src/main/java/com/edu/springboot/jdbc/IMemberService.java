package com.edu.springboot.jdbc;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMemberService
{
	// 추상 매서드가 있어야 함
	public int insert(String id, String pass, String name); // 회원정보추가
//	public List<MemberDTO> select(); // 회원목록(검색이 없는)
	public List<MemberDTO> select(MemberDTO memberDTO); // 회원목록(검색이 있는)
	public MemberDTO selectOne(@Param("_id") String id); // "_id" !!!
	public int update(Map<String, String> paramMap);
	public int delete(String id);
}
