package kr.co.sentshare;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sentshare.SentShareDTO;
import kr.co.utility.Utility;

@Controller
public class SentShareCont {
	
	@Autowired
	private SentShareDAO dao;
	
	public SentShareCont(){
		System.out.println("---SentShareCont°´Ã¼ »ý¼ºµÊ");
	}
	
	@RequestMapping(value="/main/create.do", method=RequestMethod.GET)
	public ModelAndView createForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/createForm");
		return mav;
	}
	
	@RequestMapping(value="/main/create.do", method=RequestMethod.POST)
	public ModelAndView createProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.create(dto);
		mav.setViewName("redirect:/main/list.do"); // /mediagroup/msgView.jsp		
		return mav;
	}
	
	@RequestMapping("/main/list.do")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/list"); // /main/list.jsp
		ArrayList<SentShareDTO> list = dao.list();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value="/main/read.do", method=RequestMethod.GET)
	public ModelAndView read(int bbsno){
		dao.readcnt(bbsno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/read");
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}//read() end
	
	@RequestMapping(value="/main/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteForm(int bbsno){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/deleteForm");
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping(value="/main/delete.do", method=RequestMethod.POST)
	public ModelAndView deleteProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.delete(dto);
		mav.setViewName("redirect:/main/list.do");
		return mav;
	}
	
	@RequestMapping(value="/main/update.do", method=RequestMethod.GET)
	public ModelAndView updateForm(int bbsno){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/updateForm");
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@RequestMapping(value="/main/update.do", method=RequestMethod.POST)
	public ModelAndView updateProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.update(dto);
		mav.setViewName("redirect:/main/list.do");
		return mav;
	}
}
