package kr.re.kiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.re.kiro.service.AnnounceService;

@Controller
public class AnnounceController {
	
	@Autowired
	private AnnounceService announceService;

	@RequestMapping(value = "/alert/business", method = RequestMethod.GET)
	public ModelAndView businessList(Model model, HttpSession session) throws Exception {
		//if (null == session.getAttribute("userSession")) {
		//	return new ModelAndView("redirect:/");
		//}
		model.addAttribute("list", announceService.listAll());
		return new ModelAndView("alert/business-announcement");
    }
	
	@RequestMapping(value = "/alert/business/regist", method = RequestMethod.GET)
	public ModelAndView businessRegistGET(Model model, HttpSession session) throws Exception {
		return new ModelAndView("alert/business-announcement-regist");
	}
	
	@RequestMapping(value = "/alert/business/regist", method = RequestMethod.POST)
	public ModelAndView businessRegistPOST(Model model, HttpSession session, RedirectAttributes rttr) throws Exception {
		announceService.regist("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("alert/business-announcement-regist");
    }
	
	@RequestMapping(value = "/alert/business/read", method = RequestMethod.GET)
	public ModelAndView businessRead(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", announceService.read(id));
		return new ModelAndView("alert/business-announcement-read");
	}
	
	@RequestMapping(value = "/alert/business/modify", method = RequestMethod.GET)
	public ModelAndView businessModifyGET(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", announceService.read(id));
		return new ModelAndView("alert/business-announcement-modify");
    }
	
	@RequestMapping(value = "/alert/business/modify", method = RequestMethod.POST)
	public ModelAndView businessModifyPOST(Model model, HttpSession session, RedirectAttributes rttr) throws Exception {
		announceService.modify("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("alert/business");
    }
	
	@RequestMapping(value = "/alert/business/delete", method = RequestMethod.GET)
	public ModelAndView businessDelete(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		announceService.delete(id);
		return new ModelAndView("alert/business");
    }
}
