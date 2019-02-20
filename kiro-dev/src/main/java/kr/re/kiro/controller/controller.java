package kr.re.kiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {

	@RequestMapping("/abt/greet")
	public String index1(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "abt/greet";
	}
	
	@RequestMapping("/abt/map")
	public String index2(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "abt/map";
	}
	
	@RequestMapping("/abt/org")
	public String index3(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "abt/organization";
	}
	
	@RequestMapping("/dev/res-field")
	public String index4(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "dev/research-field";
	}
	
	@RequestMapping("/dev/res-result")
	public String index5(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "dev/research-result";
	}
	
	@RequestMapping("/alert/business")
	public String index6(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "alert/business-announcement";
	}
	
	@RequestMapping("/alert/notice")
	public String index7(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "alert/notice";
	}
	
	@RequestMapping("/alert/qna")
	public String index8(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "alert/qna";
	}
	
	@RequestMapping("/login")
	public String index9(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "view/login";
	}
	
	@RequestMapping("/signup")
	public String index10(Model model) {
		model.addAttribute("name", "SpringBlog from Millky");
		return "view/signup";
	}
	
}