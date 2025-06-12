package com.edu.springboot;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardVO
{
	private int idx;
	@NotNull(message = "아이디가 null 입니다.")
	@NotEmpty(message = "아이디를 입력해주세요.")
	@Size(min = 5, max = 12, message = "아이디는 5~12자로 입력해주세요.")
	private String userid;
	
	@NotNull(message = "제목이 null 입니다.")
	@NotEmpty(message = "제목을 입력해주세요.")
	private String title;
	
	@NotNull(message = "내용이 null 입니다.")
	@NotEmpty(message = "내용을 입력해주세요.")
	private String content;
}
