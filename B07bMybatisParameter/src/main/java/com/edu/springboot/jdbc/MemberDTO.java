package com.edu.springboot.jdbc;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO
{
	// 멤버변수 선언
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
//	검색을 위한 멤버변수 선언
	private List<String> searchField; // 체크 박스이므로 2개 이상의 항목을 저장하기 위해 list
	private String searchKeyword;
}
