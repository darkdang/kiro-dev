package kr.re.kiro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.re.kiro.service.QNAService;

@Controller
public class QNAController {
	
	@Autowired
	private QNAService qnaService;

	@RequestMapping(value = "/alert/qna", method = RequestMethod.GET)
	public ModelAndView qnaList(Model model, HttpSession session) throws Exception {
		//if (null == session.getAttribute("userSession")) {
		//	return new ModelAndView("redirect:/");
		//}
		model.addAttribute("list", qnaService.listAll());
		return new ModelAndView("alert/qna");
    }
	
	@RequestMapping(value = "/alert/qna/regist", method = RequestMethod.GET)
	public ModelAndView qnaRegistGET(Model model, HttpSession session) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd" );
		Date time = new Date();
		String curTime = format.format(time);
		return new ModelAndView("alert/qna-regist","time",curTime);
	}
	
	@RequestMapping(value = "/alert/qna/regist", method = RequestMethod.POST)
	public ModelAndView qnaRegistPOST(Model model, HttpSession session, RedirectAttributes rttr,@RequestParam("user_name") String userName,@RequestParam("created_on") String createdOn,@RequestParam("subject") String subject,@RequestParam("contents") String contents) throws Exception {
		qnaService.regist("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("alert/qna");
    }
	
	@RequestMapping(value = "/alert/qna/read", method = RequestMethod.GET)
	public ModelAndView qnaRead(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", qnaService.read(id));
		return new ModelAndView("alert/qna-read");
	}
	
	@RequestMapping(value = "/alert/qna/modify", method = RequestMethod.GET)
	public ModelAndView qnaModifyGET(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", qnaService.read(id));
		return new ModelAndView("alert/qna-modify");
    }
	
	@RequestMapping(value = "/alert/qna/modify", method = RequestMethod.POST)
	public ModelAndView qnaModifyPOST(Model model, HttpSession session, RedirectAttributes rttr) throws Exception {
		qnaService.modify("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("alert/qna");
    }
	
	@RequestMapping(value = "/alert/qna/delete", method = RequestMethod.GET)
	public ModelAndView qnaDelete(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		qnaService.delete(id);
		return new ModelAndView("alert/qna");
    }
}
