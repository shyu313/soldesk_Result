package kr.co.playlist;

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
public class PlaylistController {
	public static Logger logger = LoggerFactory.getLogger(PlaylistController.class);
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/playlist/Toplist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Toplist() {
		logger.debug("검색 테스트");
		System.out.println("탑100");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/Toplist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Toplist() end
	
	@RequestMapping("/playlist/Randomplay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Randomplay() {
		logger.debug("검색 테스트");
		System.out.println("랜덤듣기");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/Randomplay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Randomplay() end
	
	@RequestMapping("/playlist/Emotion.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotion() {
		logger.debug("감성보기");
		System.out.println("루시테스트");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/Emotion");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Emotion() end
}
