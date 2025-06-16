package com.edu.springboot.jdbc;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IBoardService
{
//	조회
	public int getTotalCount(ParameterDTO parameterDTO);
	public ArrayList<BoardDTO> listPage(ParameterDTO parameterDTO);
//	작성
	public int write(@Param("_name") String name,
			@Param("_title") String title, @Param("_content") String content);
//	내용보기 || 수정
	public BoardDTO view(BoardDTO boardDTO);
//	수정
	public int edit(BoardDTO boardDTO);
//	삭제
	public int delete(String idx);
}
