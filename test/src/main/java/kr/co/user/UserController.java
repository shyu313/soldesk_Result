package kr.co.user;

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
public class UserController {
	public static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/user/Private.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Private() {
		logger.debug("검색 테스트");
		System.out.println("개인 정보");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/Private");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Private() end
	
	@RequestMapping("/user/Customer.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Customer() {
		logger.debug("검색 테스트");
		System.out.println("고객 센터");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/Customer");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // index() end
}
