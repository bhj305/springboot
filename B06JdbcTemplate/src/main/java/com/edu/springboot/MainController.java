package com.edu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;

@Controller
public class MainController
{
	@Autowired
	IMemberService dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/list.do")
	public String member2(Model model) {
		model.addAttribute("memberList", dao.select());
		return "list";
	}
//	@RequestMapping(value = "/regist.do", method = RequestMethod.GET)
	@GetMapping("/regist.do")
	public String member1() {
		return "regist";
	}
//	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	@PostMapping("/regist.do")
	public String member6(MemberDTO memberDTO) {
		int result = dao.insert(memberDTO);
		if(result == 1) System.out.println("입력되었습니다.");
		return "redirect:list.do";
	}
	
//	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	@GetMapping("/edit.do")
	public String member3(MemberDTO memberDTO, Model model) {
		memberDTO = dao.selectOne(memberDTO);
		model.addAttribute("dto", memberDTO);
		return "edit";
	}
	
	@PostMapping("edit.do")
	public String member7(MemberDTO memberDTO) {
		int result = dao.update(memberDTO);
		if(result == 1) System.out.println("수정되었습니다.");
		return "redirect:list.do";
	}
	
	
}
