package com.edu.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController
{
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/write.do")
	public String insert() {
		return "write";
	}
	
	
	@RequestMapping("/writeAction1.do")
	public String writeAction1(@ModelAttribute("dto") BoardDTO boardDTO, BindingResult result) {
		String page = "result";
		System.out.println(boardDTO);
		
		BoardValidator validator = new BoardValidator();
		validator.validate(boardDTO, result);
		
		if(result.hasErrors()) {
			page = "write";
			System.out.println("검증 실패 반환값1:"+result.toString());
			System.out.println("=================================");
			
			if(result.getFieldError("title") != null) {
				System.out.println("제목 검증1(에러코드):" + result.getFieldError("title").getCode());
			}
			
			if(result.getFieldError("content") != null) {
				System.out.println("내용 검증1(디폴트 메세지):"+result.getFieldError("content").getDefaultMessage());
			}
		}
		return page;
	}
	
	@RequestMapping("/writeAction2.do")
	public String writeAction2(@ModelAttribute("dto") @Validated BoardVO boardVO, BindingResult result) {
		String page = "result";
		System.out.println(boardVO);
		
//		검증을 위한 클래스는 별도로 정의할 필요 없음
//		BoardValidator validator = new BoardValidator();
//		validator.validate(boardVO, result);
		
		if(result.hasErrors()) {
			page = "write";
			System.out.println("검증 실패 반환값2:"+result.toString());
			System.out.println("=================================");
			
			if(result.getFieldError("title") != null) {
				System.out.println("제목 검증2(에러코드):" + result.getFieldError("title").getCode());
			}
			
			if(result.getFieldError("content") != null) {
				System.out.println("내용 검증2(디폴트 메세지):"+result.getFieldError("content").getDefaultMessage());
			}
		}
		return page;
	}
	
	
	
	
	
}
