package com.edu.springboot.jdbc;

import lombok.Data;

@Data
public class MemberDTO
{
	// 멤버변수 선언
	private String id;
	private String pass;
	private String name;
	private String regidate;
}
