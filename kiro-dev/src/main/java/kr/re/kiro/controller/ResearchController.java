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

import kr.re.kiro.service.ResearchService;

@Controller
public class ResearchController {
	
	@Autowired
	private ResearchService researchService;

	@RequestMapping("/dev/res-field")
	public String resField(Model model) {
		return "dev/research-field";
	}

	@RequestMapping(value = "/dev/res-result", method = RequestMethod.GET)
	public ModelAndView resResultList(Model model, HttpSession session) throws Exception {
		//if (null == session.getAttribute("userSession")) {
		//	return new ModelAndView("redirect:/");
		//}
		model.addAttribute("list", researchService.listAll());
		return new ModelAndView("dev/res-result");
    }
	
	@RequestMapping(value = "/dev/res-result/regist", method = RequestMethod.GET)
	public ModelAndView resResultRegistGET(Model model, HttpSession session) throws Exception {
		return new ModelAndView("dev/res-result-regist");
	}
	
	@RequestMapping(value = "/dev/res-result/regist", method = RequestMethod.POST)
	public ModelAndView resResultRegistPOST(Model model, HttpSession session, RedirectAttributes rttr) throws Exception {
		researchService.regist("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("dev/res-result-regist");
    }
	
	@RequestMapping(value = "/dev/res-result/read", method = RequestMethod.GET)
	public ModelAndView resResultRead(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", researchService.read(id));
		return new ModelAndView("dev/res-result-read");
	}
	
	@RequestMapping(value = "/dev/res-result/modify", method = RequestMethod.GET)
	public ModelAndView resResultModifyGET(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		model.addAttribute("content", researchService.read(id));
		return new ModelAndView("dev/res-result-modify");
    }
	
	@RequestMapping(value = "/dev/res-result/modify", method = RequestMethod.POST)
	public ModelAndView resResultModifyPOST(Model model, HttpSession session, RedirectAttributes rttr) throws Exception {
		researchService.modify("something");
		rttr.addFlashAttribute("msg", "success");
		return new ModelAndView("dev/res-result");
    }
	
	@RequestMapping(value = "/dev/res-result/delete", method = RequestMethod.GET)
	public ModelAndView resResultDelete(Model model, HttpSession session, @RequestParam("id") int id) throws Exception {
		researchService.delete(id);
		return new ModelAndView("dev/res-result");
    }
	
}
