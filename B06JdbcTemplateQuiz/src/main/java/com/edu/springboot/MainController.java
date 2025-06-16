package com.edu.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.springboot.jdbc.IMemberService;
import com.edu.springboot.jdbc.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;

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
	public String member2(Model model ,HttpServletRequest req) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		request 내장 객체를 통해 파라미터를 가져옴
		String searchField = req.getParameter("searchField");
		String searchKeyword = req.getParameter("searchKeyword");
		
		if(searchKeyword != null) {
			map.put("searchField", searchField);
			map.put("searchKeyword", searchKeyword);
		}
		
		req.setAttribute("map", map);
		model.addAttribute("memberList", dao.select(map));
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
	
	@RequestMapping("/delete.do")
	public String member4(MemberDTO memberDTO) {
		int result = dao.delete(memberDTO);
		if(result == 1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
	
}
