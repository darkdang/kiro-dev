package kr.re.kiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/abt/greet")
	public String greet(Model model) {
		return "abt/greet";
	}
	
	@RequestMapping("/abt/map")
	public String map(Model model) {
		return "abt/map";
	}
	
	@RequestMapping("/abt/org")
	public String orgaization(Model model) {
		return "abt/organization";
	}
	
	@RequestMapping("/alert/business")
	public String business(Model model) {
		return "alert/business-announcement";
	}
	
	
}