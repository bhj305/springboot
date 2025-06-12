package com.edu.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 인수를 가진 생성자 BoardDTO(int, String, String, String)
@NoArgsConstructor // 기본 생성자
public class BoardDTO
{
	private int idx;
	private String userid;
	private String title;
	private String content;
}
