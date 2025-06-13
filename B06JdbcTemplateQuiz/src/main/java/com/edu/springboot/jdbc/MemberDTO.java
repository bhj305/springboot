package com.edu.springboot.jdbc;

import lombok.Data;

@Data
public class MemberDTO
{
//	musthave 의 member 테이블과 동일하게 맞춰야함.
	private String id;
	private String pass;
	private String name;
	private String regidate;
}
