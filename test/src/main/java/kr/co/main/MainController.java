package kr.co.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MainController {
	public static Logger logger = LoggerFactory.getLogger(MainController.class);
	
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
	@RequestMapping("/main/Search.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Search() {
		logger.debug("검색 테스트");
		System.out.println("루시테스트");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/Search");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Search() end
	
	@RequestMapping("/main/Share.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Share() {
		logger.debug("공유 테스트");
		System.out.println("공유 테스트");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/Share");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Share() end
}
