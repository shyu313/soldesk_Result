
package kr.co.main;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	public static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
		@Autowired
		private SentShareDAO dao;
		
		//int recordPerPage = 10;
	//	@RequestMapping(value = "/", method = RequestMethod.GET)				
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/main/search.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Search() {
		logger.debug("search.do  테스트");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/search");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Search() end
	
	// 감성 공유 리스트 컨트롤러
	@RequestMapping("/main/share.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView list(SearchDTO searchDTO, HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/share"); // /main/share.jsp
		/*ArrayList<SentShareDTO> list = dao.list(searchDTO);
		int cnt = dao.getArticleCount(searchDTO);		
		mav.addObject("list", list);
		mav.addObject("count", cnt); // 글 전체 갯수
*/		return mav;
	} // Share() end
	
	// 감성 공유 작성 폼 컨트롤러
	@RequestMapping(value="/main/create.do", method=RequestMethod.GET)
	public ModelAndView createForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/createForm");
		return mav;
	}
	
	// 감성 공유 처리 컨트롤러
	@RequestMapping(value="/main/create.do", method=RequestMethod.POST)
	public ModelAndView createProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.create(dto);
		mav.setViewName("redirect:/main/share.do"); // /mediagroup/msgView.jsp		
		return mav;
	}
	
	// 감성 공유 조회 컨트롤러
	@RequestMapping(value="/main/read.do", method=RequestMethod.GET)
	public ModelAndView read(int bbsno){
		dao.readcnt(bbsno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/read");
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}//read() end
	
	// 감성 공유 삭제 폼 컨트롤러 
	@RequestMapping(value="/main/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteForm(int bbsno){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/deleteForm");
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}
	
	// 감성 공유 삭제 처리 컨트롤러
	@RequestMapping(value="/main/delete.do", method=RequestMethod.POST)
	public ModelAndView deleteProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.delete(dto);
		mav.setViewName("redirect:/main/share.do");
		return mav;
	}
	
	// 감성 공유 수정 폼 컨트롤러
	@RequestMapping(value="/main/update.do", method=RequestMethod.GET)
	public ModelAndView updateForm(int bbsno){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/updateForm");
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}
	
	// 감성 공유 수정 처리 컨트롤러
	@RequestMapping(value="/main/update.do", method=RequestMethod.POST)
	public ModelAndView updateProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.update(dto);
		mav.setViewName("redirect:/main/share.do");
		return mav;
	}
}
