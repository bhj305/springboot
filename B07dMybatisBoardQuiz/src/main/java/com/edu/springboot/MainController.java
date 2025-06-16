package com.edu.springboot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.springboot.jdbc.BoardDTO;
import com.edu.springboot.jdbc.IBoardService;
import com.edu.springboot.jdbc.ParameterDTO;
import com.edu.springboot.utils.PagingUtil;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class MainController
{
	@Autowired
	IBoardService dao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
//	멤버변수 설정 
	@Value("#{myprops['my.pageSize']}")
	int propPageSize;
	@Value("#{myprops['my.blockPage']}")
	int propBlockPage;
	
	@RequestMapping("/list.do")
	public String boardList(Model model, HttpServletRequest req, ParameterDTO parameterDTO) {
		int totalCount = dao.getTotalCount(parameterDTO);
//		int pageSize = 2;
//		int blockPage = 2;
		int pageSize = this.propPageSize;
		int blockPage = this.propBlockPage;
		
//		System.out.println(this.propPageSize +", " + this.propBlockPage); // 디버깅 확인용
		
		int pageNum = (req.getParameter("pageNum") == null || req.getParameter("pageNum").equals("")) 
			? 1 : Integer.parseInt(req.getParameter("pageNum"));
		int start = (pageNum - 1) * pageSize + 1;
		int end = pageNum * pageSize;
		parameterDTO.setStart(start);
		parameterDTO.setEnd(end);
		
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("totalCount", totalCount);
		maps.put("pageSize", pageSize);
		maps.put("pageNum", pageNum);
		model.addAttribute("maps", maps);
		
		ArrayList<BoardDTO> lists = dao.listPage(parameterDTO);
		model.addAttribute("lists", lists);
		
		String pagingImg = 
				PagingUtil.pagingImg(totalCount, pageSize, blockPage, pageNum, req.getContextPath()+"/list.do?");
		model.addAttribute("pagingImg", pagingImg);
		
		return "list";
				
	}
	@GetMapping("/write.do")
	public String boardWriteGet(Model model) {
		return "write";
	}
	
	@PostMapping("/write.do")
	public String boardWritePost(Model model, HttpServletRequest req) {
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		int result = dao.write(name, title, content);
		
		return "redirect:list.do"; // 서비스 인터페이스 호출
	}
	
	@RequestMapping("/view.do")
	public String boardView(Model model, BoardDTO boardDTO) {
		dao.visitCountPlus(boardDTO); // (조회수 증가용 함수)visitCountPlus 함수 먼저 실행되도록 설정
		boardDTO = dao.view(boardDTO);
		boardDTO.setContent(boardDTO.getContent().replace("\r\n", "<br/>"));
		model.addAttribute("boardDTO", boardDTO);
		return "view";
	}
	
//	수정 1: 기존 내용 읽어오기
	@GetMapping("/edit.do")
	public String boardEditGet(Model model, BoardDTO boardDTO) {
		boardDTO = dao.view(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		
		return "edit";
	}
//	수정 내용 전송
	@PostMapping("edit.do")
	public String boardEditPost(BoardDTO boardDTO) {
		int result = dao.edit(boardDTO);
		
		return "redirect:view.do?idx=" + boardDTO.getIdx();
	}
	@PostMapping("/delete.do")
	public String boardDeletePost(HttpServletRequest req) {
		int result = dao.delete(req.getParameter("idx"));
		return "redirect:list.do"; 
	}
	
}
