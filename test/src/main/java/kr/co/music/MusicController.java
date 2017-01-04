package kr.co.music;

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
public class MusicController {
	public static Logger logger = LoggerFactory.getLogger(MusicController.class);
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/music/Replay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Replay() {
		logger.debug("검색 테스트");
		System.out.println("다시듣기");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/Replay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Replay() end
	
	@RequestMapping("/music/Emotionlist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotionlist() {
		logger.debug("검색 테스트");
		System.out.println("감정그래프");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/Emotionlist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Emotionlist() end
}
