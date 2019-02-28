package kr.re.kiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResearchController {
	
	@RequestMapping("/dev/res-field")
	public String resField(Model model) {
		return "dev/research-field";
	}
	
	@RequestMapping("/dev/res-result")
	public String resResult(Model model) {
		return "dev/research-result";
	}
	
}
