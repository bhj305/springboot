package com.edu.springboot.jdbc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterDTO
{
	// 검색어 
	private String searchField;
	private String searchKeyword;
	// 개시물 구간 표현
	private int start;
	private int end;
}
