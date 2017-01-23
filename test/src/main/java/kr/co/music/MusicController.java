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
 
import kr.co.dao.HistoryDAO;
import kr.co.dao.MediaDAO;
import kr.co.dto.HistoryDTO;
import kr.co.dto.MediaDTO;
import kr.co.utility.Utility;
@Controller
public class MusicController {
	public static Logger logger = LoggerFactory.getLogger(MusicController.class);
	@Autowired
	HistoryDAO historyDAO;

	@RequestMapping("/music/replay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Replay(HistoryDTO historyDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/replay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<HistoryDTO> musicList= historyDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		//JSONObject jsonEmotion = Utility.getHistoryMusic(musicList);	 
		mav.addObject("list",musicList);

		return mav;
	} // Replay() end
	
	@RequestMapping("/music/emotionlist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotionlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/emotionlist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<HistoryDTO> musicList= historyDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		//JSONObject jsonEmotion = Utility.getHistoryMusic(musicList);	 
		mav.addObject("list",musicList);

		return mav;
	} // Emotionlist() end
}


