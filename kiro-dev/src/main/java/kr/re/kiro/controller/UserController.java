package kr.re.kiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model, HttpSession session) {
		if (null == session.getAttribute("userSession")) {
			return new ModelAndView("view/login");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		return "view/signup";
	}
	
}
