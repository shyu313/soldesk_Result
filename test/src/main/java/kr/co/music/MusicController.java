package kr.co.music;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dao.MediaDAO;
import kr.co.dto.MediaDTO;
import kr.co.utility.Utility;
@Controller
public class MusicController {
	public static Logger logger = LoggerFactory.getLogger(MusicController.class);
	@Autowired
	private MediaDAO mediaDAO;
	
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/music/replay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Replay() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/replay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		
		return mav;
	} // Replay() end
	
	@RequestMapping("/music/emotionlist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotionlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/emotionlist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	} // Emotionlist() end
}
