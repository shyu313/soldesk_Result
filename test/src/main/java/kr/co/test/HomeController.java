package kr.co.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
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

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MediaDAO musicDAO;
	
	@RequestMapping("/index.do")
	public ModelAndView index() throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
	 	
		MediaDTO musicDTO = musicDAO.read(255);		// lyricsNo 255 야생화
	 	logger.debug( "\n가수 : "+  musicDTO.getTitle() +"\n가사 : "+ musicDTO.getLyrics());
	 	
	 	String url[] = musicDTO.getUrl().split("="); 		 	// www.youtube.com/watch?v=OxgiiyLp5pk  = 기준으로 videoId 구분
	 	String lyrics=musicDTO.getLyrics();
		String line="";
		mav.addObject("videoId", url[1]);
		mav.addObject("lyrics", lyrics);
		
		return mav;
	} // index() end
}
