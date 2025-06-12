package com.edu.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController
{
	
	@RequestMapping("/notview")
	@ResponseBody
	public String main() {
		return "View 없이 컨트롤러에서 즉시 출력";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@Value("${test.key1}")
	private String testKey1;
	@Value("${test.key2}")
	private String testKey2;
	
	@RequestMapping("/link1")
	public String link1(Model model, @Value("${test.key3}") List<String> testKey3) {
		System.out.println("testKey1= "+testKey1);
		System.out.println("testKey2= "+testKey2);
		System.out.println("testKey3= "+testKey3);
		
		model.addAttribute("testKey1", testKey1);
		model.addAttribute("testKey2", testKey2);
		model.addAttribute("testKey3", testKey3);
		
		return "link1";
	}
	
	@Value("#{myprops['my.id']}")
	private String myId;
	@Value("#{myprops['my.pass']}")
	private String myPass;
	@Value("#{myprops['my.address']}")
	private String myAddress;
	@Value("#{myprops['my.age']}")
	private String myAge;
	
	@RequestMapping("/link2")
	public String link2(Model model) {
		System.out.println("myId= " + myId);
		System.out.println("myPass= " + myPass);
		System.out.println("myAddress= " + myAddress);
		System.out.println("myAge= " + myAge);
		
		model.addAttribute("myId",myId);
		model.addAttribute("myPass",myPass);
		model.addAttribute("myAddress",myAddress);
		model.addAttribute("myAge",myAge);
		
		return "link2";
		
	}
	
}
