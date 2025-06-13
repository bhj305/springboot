package com.edu.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String member2(Model model, MemberDTO memberDTO) {
		System.out.println(memberDTO.getSearchField());
		System.out.println(memberDTO.getSearchKeyword());
		
		model.addAttribute("memberList", dao.select(memberDTO));
		return "list";
	}
//	@RequestMapping(value = "/regist.do", method = RequestMethod.GET)
	@GetMapping("/regist.do")
	public String member1() {
		return "regist";
	}
	
//	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	@PostMapping("/regist.do")
	public String member6(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		
		int result = dao.insert(id, pass, name);
		if(result == 1) System.out.println("입력되었습니다.");
		return "redirect:list.do";
	}
	
//	@RequestMapping(value = "/edit.do", method = RequestMethod.GET)
	@GetMapping("/edit.do")
	public String member3(HttpServletRequest req, MemberDTO memberDTO, Model model) {
		memberDTO = dao.selectOne(req.getParameter("id"));
		model.addAttribute("dto", memberDTO);
		return "edit";
	}
	
	@PostMapping("edit.do")
	public String member7(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("m_id", id);
		paramMap.put("m_pass", pass);
		paramMap.put("m_name", name);
		
		int result = dao.update(paramMap);
		if(result == 1) System.out.println("수정되었습니다.");
		return "redirect:list.do";
	}
	
	@RequestMapping("/delete.do")
	public String member4(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		int result = dao.delete(id);
		if(result == 1) System.out.println("삭제되었습니다.");
		return "redirect:list.do";
	}
}
