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
	private MediaDAO musicDAO;
	
	@RequestMapping("/index.do")
	public ModelAndView index() throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
	 	
		MediaDTO fixedDTO = musicDAO.read(255);					// 야생화 고정
		List<MediaDTO> musicList= musicDAO.list();				// 전체 노래 정보 조회
		Iterator<MediaDTO> iterator = musicList.iterator();
		String emotionType[] ={"happy","disgust","fear","interest","pain","rage","sad"};
		int count[] = new int[7];
		while(iterator.hasNext()){
			MediaDTO dto = iterator.next();
			if(dto.getHappy()>15)		{count[0]++;}		// 0 기쁨
			if(dto.getDisgust()>15)		{count[1]++;}		// 1 혐오
			if(dto.getFear()>15)			{count[2]++;}		// 2 공포
			if(dto.getInterest()>15)		{count[3]++;}		// 3 흥미
			if(dto.getPain()>15)			{count[4]++;}		// 4 아픔
			if(dto.getRage()>15)		{count[5]++;}		// 5 분노
			if(dto.getSad()>15)			{count[6]++;}		// 6 슬픔
		}
		
		// 최종 완성될 JSONObject 선언(전체)
		JSONObject jsonObject = new JSONObject();
		// person의 JSON정보를 담을 Array 선언
		JSONArray jsonArray = new JSONArray();
		// person의 한명 정보가 들어갈 JSONObject 선언
		JSONObject jsonEmotion = new JSONObject();
		
		for(int i=0; i<emotionType.length; i++){
			jsonEmotion.put(emotionType[i], count[i]);
			
		}
		
		logger.debug(jsonEmotion.toString());
		


		
		
	 	String url[] = fixedDTO.getUrl().split("="); 		 	// www.youtube.com/watch?v=OxgiiyLp5pk  = 기준으로 videoId 구분
	 	String lyrics=fixedDTO.getLyrics();
		String line="";
		mav.addObject("videoId", url[1]);
		mav.addObject("lyrics", lyrics);
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	} // index() end
}
