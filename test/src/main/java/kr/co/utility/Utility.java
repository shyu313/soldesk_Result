package kr.co.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
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
	
} // class end
