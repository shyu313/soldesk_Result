package kr.co.playlist;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

@Controller
public class PlaylistController {
	public static Logger logger = LoggerFactory.getLogger(PlaylistController.class);
	
	@Autowired
	MediaDAO mediaDAO;
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping("/playlist/toplist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Toplist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/toplist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
	 	List<MediaDTO> musicList=mediaDAO.toplist(); 
	 	//logger.debug( "\n가수 : "+  musicDTO.getTitle() +"\n가사 : "+ musicDTO.getLyrics());
		mav.addObject("topList", musicList);
		
		return mav;
	} // Toplist() end
	@RequestMapping(value="/playlist/toplistplay.do", method=RequestMethod.GET)
	public ModelAndView play(MediaDTO mediaDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/toplist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.

		mediaDTO = mediaDAO.read(mediaDTO.getLyricsNo());
		String url[]=mediaDTO.getUrl().split("=");
		
		mav.addObject("videoId", url[1]);
		mav.addObject("lyrics", mediaDTO.getLyrics());
		logger.debug("\nurl : " + url[1]+ "\n가사: "+ mediaDTO.getLyrics());
		
		
		
		return mav;
	} // play() end
	
	@RequestMapping("/playlist/randomplay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Randomplay() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/randomplay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Randomplay() end
	
	@RequestMapping("/playlist/emotion.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotion() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("playlist/emotion");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		return mav;
	} // Emotion() end
}
