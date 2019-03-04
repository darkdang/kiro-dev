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

import kr.re.kiro.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "/alert/notice", method = RequestMethod.GET)
	public ModelAndView noticeList(Model model, HttpSession session) throws Exception {
		//if (null == session.getAttribute("userSession")) {
		//	return new ModelAndView("redirect:/");
		//}
		model.addAttribute("list", noticeService.listAll());
		return new ModelAndView("alert/notice");
    }
	
	@RequestMapping(value = "/alert/notice/regist", method = RequestMethod.GET)
	public ModelAndView noticeRegistGET(Model model, HttpSession session) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd" );
		Date time = new Date();
		String curTime = format.format(time);
		return new ModelAndView("alert/notice-regist","time",curTime);
	}
	
	@RequestMapping(value = "/alert/notice/regist", method = RequestMethod.POST)
	public ModelAndView noticeRegistPOST(Model model, HttpSession session, RedirectAttributes rttr,@RequestParam("user_name") String userName,@RequestParam("created_on") String createdOn,@RequestParam("subject") String subject,@RequestParam("contents") String contents) throws Exception {
		noticeService.regist("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("alert/notice");
    }
	
	@RequestMapping(value = "/alert/notice/read", method = RequestMethod.GET)
	public ModelAndView noticeRead(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", noticeService.read(id));
		return new ModelAndView("alert/notice-read");
	}
	
	@RequestMapping(value = "/alert/notice/modify", method = RequestMethod.GET)
	public ModelAndView noticeModifyGET(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", noticeService.read(id));
		return new ModelAndView("alert/notice-modify");
    }
	
	@RequestMapping(value = "/alert/notice/modify", method = RequestMethod.POST)
	public ModelAndView noticeModifyPOST(Model model, HttpSession session, RedirectAttributes rttr) throws Exception {
		noticeService.modify("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("alert/notice");
    }
	
	@RequestMapping(value = "/alert/notice/delete", method = RequestMethod.GET)
	public ModelAndView noticeDelete(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		noticeService.delete(id);
		return new ModelAndView("alert/notice");
    }
}
