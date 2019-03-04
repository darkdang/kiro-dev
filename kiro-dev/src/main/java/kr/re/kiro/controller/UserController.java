package kr.re.kiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.re.kiro.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model, HttpSession session) {
		if (null == session.getAttribute("userSession")) {
			return new ModelAndView("view/login");
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Model model, HttpSession session, @RequestParam(value = "email") String email, @RequestParam(value = "passwd") String passwd) {
		
//		String msg = null;
//
//		msg = validateLogin(email, passwd);
//		if (msg != null) {
//		} else {
//			// TODO login 까지 봇 check를 해야하나?
//			// if(rcResponse.isSuccess()) {
//			boolean result = userService.loginCheck(email, passwd);
//			if (!result) {
//				msg = "login.err.invalid";
//			} else {
//				User user = userService.getUser(email);
//				if (null == user) {
//					msg = "login.err.invalid";
//				} else if (UserStatusType.Join == user.getStatus()) {
//					msg = "login.msg.confirm";
//				} else {
//					// 정상 로그인
//					model.addAttribute("userName", user.getUserName());
//					model.addAttribute("email", user.getEmail());
//					Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
//					user.setLastAccessedOn(date);
//					userService.updateAccessedDate(user);
//					log.debug("userSession = {}", user);
//					session.setAttribute("userSession", user);
//
//				}
//			}
//			// } else {
//			// msg = "로봇이 아닙니다를 체크해주세요.";
//			// }
//		}
//
//		if (msg == null) {
//			return new ModelAndView("redirect:/documents");
//		} else {
//			model.addAttribute("message", msg);
//			model.addAttribute("email", email);
//			model.addAttribute("passwd", passwd);
			return new ModelAndView("view/login");
//		}
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		return "view/signup";
	}
	
}
