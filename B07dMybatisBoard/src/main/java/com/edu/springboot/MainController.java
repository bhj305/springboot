package com.edu.springboot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/list.do")
	public String boardList(Model model, HttpServletRequest req, ParameterDTO parameterDTO) {
		int totalCount = dao.getTotalCount(parameterDTO);
		int pageSize = 2;
		int blockPage = 2;
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
	
}
