package kr.co.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.dao.MediaDAO;
import kr.co.dto.MediaDTO;
import kr.co.test.HomeController;

public class Utility {
	private static final String root = "/test";
	private static final Logger logger = LoggerFactory.getLogger(Utility.class);

	public static synchronized String getRoot() {
		return root;
	}
	
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return sdf.format(new Date());
	} // getCurrentDate() end
	
	
	// 유투브 검색결과 title 비교하기 : 3가지 경우
	public void compareTitle(String subject, String[] youtubeTitle){
		String searchSubject = subject.replace(" ", "+");				// 검색어에서 공백을 +로 
		String compare="";		// 유투브와 비교할 검색어
		String compareSource[];		// 제목을 한 단어씩 넣어둠
		
		// 1. 제목앞에 숫자가 붙는 경우
		int index = subject.indexOf(".");	
		if(index==1) {	
			searchSubject = "0"+ searchSubject.replace(".", "+");
			compare = searchSubject.substring(index+1, searchSubject.length()).replace("+", " ").toLowerCase().trim();
		} else if(index==2) {
			compare = searchSubject.substring(index+1, searchSubject.length()).replace("+", " ").toLowerCase().trim();
		} else {
			compare = subject;
		}
		compareSource = compare.split(" ");		
		// 2. 제목 자체가 틀린 경우 단어별로 정확도 측정하기
		// = titleAccuracy(urlTitle);
		// 3. 앨범명이 노래 제목과 같은 경우
	}// compareTitle() end
	
	/* Headr 관련 메소드*/
	// 전체 노래 리스트로 부터 감정별 갯수 파악
	public static JSONObject getJsonAllEmotionMusic(List<MediaDTO> musicList  ){				 
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
		return jsonEmotion;
	}
} // class end
