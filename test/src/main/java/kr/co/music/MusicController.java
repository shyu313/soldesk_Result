package kr.co.music;
 
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
import kr.co.dto.HistorySearchDTO;
import kr.co.dto.MediaDTO;
import kr.co.utility.Utility;
@Controller
public class MusicController {
	public static Logger logger = LoggerFactory.getLogger(MusicController.class);
	@Autowired
	HistoryDAO historyDAO;
	
	@Autowired
	MediaDAO mediaDAO;

	@RequestMapping("/music/replay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Replay(HistoryDTO historyDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/replay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		String username = "Ciel Lu";
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("username", username);
		
		List<MediaDTO> mumusicList= mediaDAO.list();			
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(mumusicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		List<HistoryDTO> musicList= historyDAO.list(hashMap);		
		mav.addObject("list",musicList);

		return mav;
	} // Replay() end
	
	@RequestMapping("/music/emotionlist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotionlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/emotionlist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String selectemotion = "happy";
		int selecttime = 22;
		hashMap.put("selectemotion", selectemotion);
		hashMap.put("selecttime", selecttime);

		List<MediaDTO> mumusicList= mediaDAO.list();			
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(mumusicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		List<HistorySearchDTO> musicList= historyDAO.datelist(hashMap);		
		mav.addObject("datelist",musicList);					

		return mav;
	} // Emotionlist() end
}


