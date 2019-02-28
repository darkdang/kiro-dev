package kr.re.kiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QNAController {

	@RequestMapping("/alert/qna")
	public String qna(Model model) {
		return "alert/qna";
	}
}
