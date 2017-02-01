package kr.co.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.dao.MediaDAO;
import kr.co.dto.DictionaryDTO;
import kr.co.dto.HistoryDTO;
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
		//logger.debug(jsonEmotion.toString());
		return jsonEmotion;
	}
	
	public static ArrayList<ArrayList<MediaDTO>> getEmotionMusicList(List<MediaDTO> musicList  ){				 
		
		String emotionTypeArray[] ={"happy","disgust","fear","interest","pain","rage","sad"};
		ArrayList<ArrayList<MediaDTO>> emotionMusicArrayList = new ArrayList<ArrayList<MediaDTO>>();
		for(String emotionType:emotionTypeArray){
			ArrayList<MediaDTO> dtoArrayList  = new ArrayList<MediaDTO>();
			Iterator<MediaDTO> iterator = musicList.iterator();
			while(iterator.hasNext()){
				MediaDTO mediaDTO = iterator.next();
				if(mediaDTO.getHappy()>15		&& emotionType.equals("happy"))	{mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 0 기쁨
				if(mediaDTO.getDisgust()>15		&& emotionType.equals("disgust"))	{mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 1 혐오
				if(mediaDTO.getFear()>15			&& emotionType.equals("fear"))		{mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 2 공포
				if(mediaDTO.getInterest()>15	&& emotionType.equals("interest")){mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 3 흥미
				if(mediaDTO.getPain()>15			&& emotionType.equals("pain"))		{mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 4 아픔
				if(mediaDTO.getRage()>15		&& emotionType.equals("rage"))	{mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 5 분노
				if(mediaDTO.getSad()>15			&& emotionType.equals("sad"))		{mediaDTO.setEmotion(emotionType); dtoArrayList.add(mediaDTO);}		// 6 슬픔
			}
			
			logger.debug("감정타입 : " + emotionType);
			logger.debug(String.valueOf(dtoArrayList.size()));
			emotionMusicArrayList.add(dtoArrayList);
		}
		return emotionMusicArrayList ;
	}
	
	

	public static JSONObject getHistoryMusic(List<HistoryDTO> musicList  ){				 
		Iterator<HistoryDTO> iterator = musicList.iterator();
		String emotionType[] ={"happy","disgust","fear","interest","pain","rage","sad"};
		int count[] = new int[7];//7가지 감정
		 
		while(iterator.hasNext()){
			HistoryDTO dto = iterator.next();
			if(dto.getEmotion()=="happy") {count[0]++;}
			if(dto.getEmotion()=="disgust") {count[1]++;}
			if(dto.getEmotion()=="fear") {count[2]++;}
			if(dto.getEmotion()=="interest") {count[3]++;}
			if(dto.getEmotion()=="pain") {count[4]++;}
			if(dto.getEmotion()=="rage") {count[5]++;}
			if(dto.getEmotion()=="sad") {count[6]++;}
		}
		
		// 최종 완성될 JSONObject 선언(전체)
		JSONObject jsonObject = new JSONObject();
		// person의 JSON정보를 담을 Array 선언
		JSONArray jsonArray = new JSONArray();
		// person의 한명 정보가 들어갈 JSONObject 선언
		JSONObject jsonHistory = new JSONObject();
		for(int i=0; i<emotionType.length; i++){
			jsonHistory.put(emotionType[i], count[i]);
			
		}
		//logger.debug(jsonHistory.toString());
		return jsonHistory;
	}
	
	
	/*Bubble Menu 관련 메소드*/
	// 랜덤으로 감정 별 키워드를 세개씩 반환 하는 함수
	@SuppressWarnings("unchecked")
	public static JSONObject getJsonBubbleMenu(List<DictionaryDTO> dictionaryList  ){				 
		Iterator<DictionaryDTO> iterator = dictionaryList.iterator();
		Random randomEmotion = new Random();
		String emotionType[] ={"기쁨","혐오","공포","흥미","통증","분노","슬픔"};
		ArrayList<String> listOfEmotionWord[] = new ArrayList[7];			// 감정별 단어를 담을 배열
		for(int index=0; index<listOfEmotionWord.length; index++){
			listOfEmotionWord[index] = new ArrayList<String>();
		}
		//  지루함, 놀람 빠져 있다. - 버블 차트에 추가 해야하는지 의논
		while(iterator.hasNext()){								
			DictionaryDTO dto = iterator.next();
			if(dto.getEmotion().equals("기쁨")){
				listOfEmotionWord[0].add(dto.getWord());
			}
			if(dto.getEmotion().equals("혐오")){
				listOfEmotionWord[1].add(dto.getWord());
			}
			if(dto.getEmotion().equals("공포")){
				listOfEmotionWord[2].add(dto.getWord());
			}
			if(dto.getEmotion().equals("흥미")){
				listOfEmotionWord[3].add(dto.getWord());
			}
			if(dto.getEmotion().equals("통증")){
				listOfEmotionWord[4].add(dto.getWord());
			}
			if(dto.getEmotion().equals("분노")){
				listOfEmotionWord[5].add(dto.getWord());
			}
			if(dto.getEmotion().equals("슬픔")){
				listOfEmotionWord[6].add(dto.getWord());
			}
		}
		
		/*
		 * 		json 형태 
		 *  	#1 #2 #3 jsonObject , 
		 *  	#4 #5 	JsonArray  
		 * 
		 * 	#3{ name:"bubble", children : 
		 * 		#4[
		 *  		 #2{ name:"", description:"", children: 
		 *  		#5[
		 *  				#1{ name:"", address:""}, #1{ name:"", address:""}, #1{ name:"", address:""}
		 *  			]
		 * 		 ]
		 */
																			// 추가할 jsonObject 는 필요한 data 개수<감정타입 7개, 감정단어 3개> 만큼 할당 되어야 한다.
		JSONObject jsonBubbleMenu = new JSONObject();		// #3 최종 반환값  
		JSONArray jsonMainArray =new JSONArray();			// #4 메인 버블	Array					: add로 jsonMainBubble 객체 추가 
		JSONObject jsonMainBubble = null;						// #2 메인 버블	<감정 타입> 		: 감정타입 만큼 주소 할당 필요
		JSONArray jsonSubArray =null;								// #5 서브 버블	Array					: 감정타입 만큼 주소 할당 필요
		JSONObject jsonSubBubble = null;							// #1 서브 버블 	<감정 단어>랜덤 	: 감정단어 만큼 주소 할당 필요
		
	
		for(int emotion=0; emotion<emotionType.length; emotion++){
			  int wordSize 	= listOfEmotionWord[emotion].size();				// 감정별 저장된 단어 갯수 
			  jsonMainBubble = new JSONObject();								// #2, #5 감정별 주소 할당 7개
			  jsonSubArray  = new JSONArray();								
			 
			  for(int i=0; i<3; i++){													// 단어 3개 선택 
				 jsonSubBubble = new JSONObject();							// #1 감정단어별 주소 할당
				 int wordIndex	= randomEmotion.nextInt(wordSize);			// 랜덤함수로 단어 인덱스 선정
				 String word;
				  
				  //logger.debug("감정타입:"+String.valueOf(emotion));
				  if( listOfEmotionWord[emotion].get(wordIndex).length()<4){	// ~하다 동사 제거	단, 3글자 제외 ex) 위하다		
					  word = listOfEmotionWord[emotion].get(wordIndex);		
				  }else{
					  word = listOfEmotionWord[emotion].get(wordIndex).replace("하다","");		
				  }
				  
				 // logger.debug("word:"+word);
				  jsonSubBubble.put("name", word);								// #1 감정단어
				  jsonSubBubble.put("address", "주소");
				  jsonSubArray.add(jsonSubBubble);								// jsonSubBubble 참조전달 이기 때문에 중복 저장됨. 할당 필요 
			  }
			  jsonMainBubble.put("name", emotionType[emotion]);			// #2 감정타입 
			  jsonMainBubble.put("description", "설명");
			  jsonMainBubble.put("children", jsonSubArray);					
			  
			  //logger.debug("#2 jsonMainBubble : "+ jsonMainBubble.toJSONString());			
			  
			  jsonMainArray.add(jsonMainBubble);								// #4 메인 버블 배열
			 //logger.debug("#4 jsonMainArray :  " + jsonMainArray.toJSONString());
			 
			 jsonBubbleMenu.put("children", jsonMainArray);					// mainBubble childern 										
			 
		}
		jsonBubbleMenu.put("name", "bubble");									// #3 최종 반환 json
		//logger.debug("#3 jsonBubbleMenu : "+jsonBubbleMenu.toJSONString());
	
		
		return jsonBubbleMenu;
	}
	
	
	/*simple dashBoard 관련 메소드*/
	// 감정별 점수 json 객체로 반환
	@SuppressWarnings("unchecked")
	public static JSONArray getJsonTopMusic(List<MediaDTO> mediaDTOList){
		//최종 완성될 JSONObject 선언(전체)
		JSONArray jsonTopMusic = new JSONArray();

		Iterator<MediaDTO> iteratorMedia = mediaDTOList.iterator();
		//String emotionType[] ={"Happy","Disgust","Fear","Interest","Pain","Rage","Sad"};
		ArrayList<Integer> listOfTopTenEmotion[] = new ArrayList[7];			// 한곡당 감정 점수를 담을 배열
		
		for(int index=0; index<listOfTopTenEmotion.length; index++){
			listOfTopTenEmotion[index] = new ArrayList<Integer>();
		}
		
		// 한곡 당 감정별 점수를 ArrayList에 저장
		while(iteratorMedia.hasNext()){
			MediaDTO dto = iteratorMedia.next();
			listOfTopTenEmotion[0].add(dto.getHappy());
			listOfTopTenEmotion[1].add(dto.getSad());
			listOfTopTenEmotion[2].add(dto.getRage());
			listOfTopTenEmotion[3].add(dto.getDisgust());
			listOfTopTenEmotion[4].add(dto.getInterest());
			listOfTopTenEmotion[5].add(dto.getPain());
			listOfTopTenEmotion[6].add(dto.getFear());
		}// end while
	
	/*	for(ArrayList<Integer> point : listOfTopTenEmotion){
			logger.debug(String.valueOf(point));
		}*/
	
		// 노래 한곡을 JSONObject 형태로 저장
		for(int i=0; i<10;i++){																// 전체 10곡 
			JSONObject innerJson = new JSONObject();								// #1 innerJson <감정 7가지 점수 >
			JSONObject outterJson = new JSONObject();	
			innerJson.put("happy", listOfTopTenEmotion[0].get(i));
			innerJson.put("sad", listOfTopTenEmotion[1].get(i));
			innerJson.put("rage", listOfTopTenEmotion[2].get(i));
			innerJson.put("disgust", listOfTopTenEmotion[3].get(i));
			innerJson.put("interest", listOfTopTenEmotion[4].get(i));
			innerJson.put("pain", listOfTopTenEmotion[5].get(i));
			innerJson.put("fear", listOfTopTenEmotion[6].get(i));
			outterJson.put("freq", innerJson);											// #2 outterJson index2
			outterJson.put("State", "Top"+(i+1));										// #2 outterJson index1
			jsonTopMusic.add(outterJson);
		}
		
		//logger.debug(jsonTopMusic.get(0).toString());
		return jsonTopMusic;
		
	}
	
	/*  search.do 관련 메소드 : 노래 추천을 위한 감정별 정렬 퀴리문 요청*/
	public static ArrayList<MediaDTO>[] categorizeEmotionType(MediaDAO mediaDAO){
		String emotionTypeArray[] ={"happy","sad","disgust","interest","pain","fear","rage"};
		HashMap<String, String> emotionTypeHash = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		ArrayList<MediaDTO> mediaEmotionType[] = new ArrayList[emotionTypeArray.length];		
		// 한참 헤맨 부분 : String 값 전달시 'fear' 이런식으로 들어갔다. 18.. 
		// => log4j-remix 을 이용해서 쿼리문 에러 캐치 가능해짐
		// => $ 바인딩으로 value 값을 받기 위해 해쉬맵에 담아서 전달
		for(int index=0; index<emotionTypeArray.length; index++){		
			emotionTypeHash.put("emotiontype", emotionTypeArray[index]);							// $ 바인딩 참조를 위한 해쉬맵
			mediaEmotionType[index] =  mediaDAO.listOfEmotionTpye(emotionTypeHash);			// 감정별 정렬 쿼리 요청
		}
		return mediaEmotionType;
	}// end
	/*  search.do 관련 메소드 : 중복제거 랜덤 함수 */
	public static int[] randomNumber(int size, int scope){
		logger.debug("랜덤 숫자 갯수 : " + size +"/" + "범위 : "+ scope);
		
		int randomNumbers[] = new int[size];
		Random random = new Random();
		for(int outter=0; outter<size; outter++){							
			randomNumbers[outter] = random.nextInt(scope);				// 랜덤 숫자를 생성
			for(int inner=0; inner<outter; inner++){						// 중복 숫자를 제거하기 위한 반복
				if(randomNumbers[outter]==randomNumbers[inner]){	// 중복인 경우 해당 숫자를 버리고 뒤로 돌아가 새로 생성		
					outter--;
				}
			}
		}
		return randomNumbers;
	}// end
	
	/*  search.do 관련 메소드 :  */
	
	
} // class end
