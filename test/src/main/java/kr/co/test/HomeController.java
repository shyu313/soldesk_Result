package kr.co.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kr.co.utility.Utility;

import org.json.simple.JSONArray;
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

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MediaDAO mediaDAO;
	
	@RequestMapping("/index.do")
	public ModelAndView index() throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
	 	 
		MediaDTO fixedDTO = mediaDAO.read(255);						// 야생화 고정
	 	String url[] = fixedDTO.getUrl().split("="); 		 	// www.youtube.com/watch?v=OxgiiyLp5pk  = 기준으로 videoId 구분
	 	String lyrics=fixedDTO.getLyrics();
		String line="";
		mav.addObject("videoId", url[1]);
		mav.addObject("lyrics", lyrics);
		
		List<MediaDTO> musicList= mediaDAO.list();								//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	} // index() end
}
