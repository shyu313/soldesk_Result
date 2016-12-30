package kr.co.test;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/* 
* 	감정사전 관련 메소드
* 
*  1. 감정단어 포함 문장 분류 기능	: searchEmotionLyrics() 
*  2.  
*  
* 	
*/

public class Dictionary {
	public static void main(String[] args)throws ClientProtocolException, IOException  {
		
		searchEmotionLyrics();
	}
	
	public static void searchEmotionLyrics() throws IOException{
		System.out.println("감정사전 단어 읽기 ");
		BufferedReader  emotionWordReader=null; 	// 감정사전 단어
		BufferedReader  lyricsReader=null;				// 가사 읽기
		BufferedWriter   writer = null;					// 쓰기
		String keyword ="";									// 감정사전 단어
		String lyrics ="";										// 전체 가사 
		String line ="";										// 파일단위 읽기
		int keywordcount=1;								// 감정사전 단어 카운트
		
		emotionWordReader = new BufferedReader(new FileReader("./dictionary/keyword.txt"));
		while((line = emotionWordReader.readLine()) != null) 		// 감정사전 단어 읽기
		{
			keyword += line+"\n";
			System.out.println(keywordcount+" 감정단어 : "+line);
			keywordcount++;
		}
		System.out.println("총 감정단어 개수 : "+ keywordcount);
	
		// 전체 가사를 한 스트링에 넣은 다음, 감정 단어를 포함하는 문장으로 분류
		System.out.println("==========================================전체 가사 스캔 시작=========================================== ");
		
		
		String totalLyrics="";							// 감정단어와 비교하기 위해 모든 가사를 모으자 
		
		for(int no = 5000; no < 6001; no++){										
			System.out.println(no+" 번 째, 가사 스캔");
			try {
				lyricsReader = new BufferedReader(new FileReader("./lyrics/"+no+".txt"));
				while((line = lyricsReader.readLine()) != null) { lyrics += line+"\n"; } // 제목, 가사, url 로 읽어 들임
				String lyricsArray[] = lyrics.split("\n");										// [2] 번째에 가사 저장됨	
				totalLyrics += lyricsArray[2]+" ";											// 읽은 모든 가사를 문자열에 저장 
				lyrics="";																			// 읽은 가사 초기화 
				
			} catch (FileNotFoundException e) {
				System.out.println("누락된 가사부분은 pass");
			}finally {
				emotionWordReader.close();
				lyricsReader.close();
			}
		}
		
		// 감정단어 포함 문장 분류 
		String emotionLyrics = "";														// 감정단어를 포함하는 가사 문장, 단어
		String emotionWordArray[] = keyword.split("\n");							// 감정단어 배열
		String totalLyricsArray[] = totalLyrics.split(" ");								// 모든 가사를 공백으로 구분
		int count=0;
	 	
		System.out.println("==========================================감정단어를 포함하는 문장분류 시작=========================================== ");
	 	for(String lyricsWord : totalLyricsArray){
	 		for(String emotionWord : emotionWordArray){
	 			if(lyricsWord.contains(emotionWord)){								// 가사에 감정단어가 포함되는 경우
	 				//System.out.println("포함 개수"+count);
	 				emotionLyrics +=  lyricsWord+" ";								
			 		count++;
	 			}
	 		}
		}
	 	
	 	String emotionLyricsWord[] = emotionLyrics.split(" ");								// 공백으로 분류함. 중복된 단어 및 문장 발생하게 된다.
	 	String conflictEmotion="";
	 	String conflictEmotions="";
	 	for(String temp : emotionLyricsWord){
	 		System.out.print(temp +"/");
	 	}
	 	System.out.println("");
	 	
	 	for(String word : emotionLyricsWord){									// 중복을 포함한 감정가사 반복문
	 		for(int index=0; index< emotionLyricsWord.length; index++){	// 자신을 비교대상으로 중복 감정가사 찾기
	 			if(emotionLyricsWord[index].equals(word)){					
	 				//System.out.println("중복 위치 발생 : "+index + word);
	 				//System.out.println(index); 									// @@@@@인덱스로 흐름을 이해하자. => 한 문자열에 저장 하면서 중복 문자열 제거과정
	 				emotionLyricsWord[index]="";									// 중복된 감정가사는 배열에서 제거 
	 				conflictEmotion = word;										// 감정가사를 한 문자열에 저장
	 			}
	 		}
	 		
	 		conflictEmotions += conflictEmotion+" ";							// 결과는 나오지만, 다시 한번 보자. 흐름이해
	 		
	 	}
	 	System.out.println(conflictEmotions);
	 	
	 	System.out.println("감정단어 포함 결과 출력");
	 	BufferedWriter resultWriter = new BufferedWriter(new FileWriter("./emotion/emotionKeyWordResult.txt"));				// 에러 리포트 문서
	 	String resultWord[] = conflictEmotions.split(" ");			// 한 줄씩 파일에 입력
	 	for(String word : resultWord){
	 		if(!word.equals("")){							// 중복으로 제외된 부분은 출력하지 않는다.
	 			resultWriter.write(word);
	 			resultWriter.newLine();
	 		}
	 	}
	 	resultWriter.close();
	}

}
