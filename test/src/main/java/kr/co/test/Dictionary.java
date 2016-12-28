package kr.co.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

/* 
 	감정단어 분류 작업을 위한 클래스. 
*/

public class Dictionary {
	public static void main(String[] args)throws ClientProtocolException, IOException  {
		System.out.println("감정 단어 분류 작업 시작 ");
			
			BufferedReader  emotionWordReader = new BufferedReader(new FileReader("./dictionary/keyword.txt"));
			String keyword ="";				// 감정사전 단어
			String lyrics ="";					// 전체 가사 
			String line ="";					// 파일에서 한줄씩 읽기
			int keywordcount=1;			// 감정사전 단어 카운트
		
			while((line = emotionWordReader.readLine()) != null) 		// 감정사전 단어 읽기
			{
				keyword += line+"\n";
				System.out.println(keywordcount+" 감정단어 : "+line);
				keywordcount++;
			}
			System.out.println("총 감정단어 개수 : "+ keywordcount);
			emotionWordReader.close();

			// 전체 가사를 한 스트링에 넣은 다음, 감정 단어를 포함하는 문장으로 분류
			// 전체 가사 파일 읽기
			System.out.println("==========================================전체 가사 스캔 시작=========================================== ");
			BufferedReader  lyricsReader=null;
			BufferedWriter   writer = null;
			for(int no = 5472; no < 5473; no++){										// 가사를 스캔하면서 영어/한글(일본,한자,특수무자 포함) 노래 구분 하기  
				int englishWordCount=0;
				int koreaWordCount =0;
				System.out.println(no+" 번 째, 가사 스캔");
				try {
					lyricsReader = new BufferedReader(new FileReader("./lyrics/"+no+".txt"));
					
					while((line = lyricsReader.readLine()) != null) 
					{
						for(int index=0; index<line.length(); index++){			
							if( line.charAt(index)>='A' && line.charAt(index)<='Z' || line.charAt(index)>='a' && line.charAt(index)<='z'){  	// 가사 길이와 알파벳 기준으로 영어 노래로 구별한다.
								englishWordCount++;
							}  
						}
						System.out.println("");	// 한줄띄우기
						lyrics += line+" ";		// 전체 가사를 저장할 때, 영어는 따로 저장하자 			 					
					
					} 
				
					koreaWordCount = lyrics.replace(" ","").length()-englishWordCount;		//  알파벳 / 한국어(일본,한자,특수문자 포함) 구분
					
					System.out.println(" 한글 수(그 외 문자포함)  : " + koreaWordCount);
					System.out.println(" 알파벳 수 : " + englishWordCount);
					
					if( koreaWordCount > englishWordCount || koreaWordCount >=50){		// 한글 수가 더 많거나, 한글이 50자 이상인 경우 한국노래
						System.out.println("이 노래는 영어 노래가 아닙니다.");
					}else{
						System.out.println("이 노래는 영어 노래 입니다.");
						File englishLyrics = new File("./lyrics/"+no+".txt");							// 기존의 폴더에서 삭제하고 새로운 폴더로 이동시키자 
						englishLyrics.delete();
						
						writer = new BufferedWriter(new FileWriter("./englishLyrics/"+no+".txt"));	// 팝송 노래 저장
						
						
//						//쓰기 
//						String result[] = omissionLyricsNo.split("/");
//						for(String omissionNo : result){
//					 		writer.write(omissionNo);
//					 		writer.newLine();
//					 	}
//						writer.close();		// 모든 번호를 저장한 뒤 닫기
						
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("누락된 가사부분은 pass");
				
				}finally {
					
					lyricsReader.close();
				}
				
			}
			
			String lyricsArray[] = lyrics.split(" ");										// 전체 가사를 공백을 기준으로 최소 (단어, 문장) 나눔	
			
			// 감정단어 포함 문장 분류 
//			String emotionWordArray[] = keyword.split("\n");		
//		 	String resultLyrics = "";
//		 	int count=0;
//		 	System.out.println("==========================================감정단어를 포함하는 문장분류 시작=========================================== ");
//		 	for(String lyricsWord : lyricsArray){
//		 		for(String emotionWord : emotionWordArray){
//		 			if(lyricsWord.contains(emotionWord)){							// 가사에서 한 단어 또는 문장속에 감정단어를 포함하는 경우
//		 				System.out.println("포함 개수"+count);
//				 		resultLyrics +=  lyricsWord+" ";								
//				 		count++;
//		 			}
//		 		}
//			}
//		 	String scanWord[] = resultLyrics.split(" ");								// 공백으로 분류함. 중복된 단어 및 문장 발생
//		 	resultLyrics="";																// 결과값 초기화
//		 	lyrics=""; 																		// 중복된 단어와 문장을 제외한 데이터로 가공 
//		 	
//		 	for(String conflictWord : scanWord){
//		 		for(int index=0; index<scanWord.length; index++){
//		 			if(scanWord[index].equals(conflictWord)){					// 같은 단어, 문장인 경우 하나만 저장
//		 				System.out.println(scanWord[index]+"/"+conflictWord+" : 같은 단어 발견함 중복 처리.");
//		 				resultLyrics += 
//		 			}
//		 		}
//		 	}
		 	
		 	
//		 	System.out.println("감정단어 포함 결과 출력");
//		 	BufferedWriter resultWriter = new BufferedWriter(new FileWriter("./emotion/emotionKeyWordResult.txt"));				// 에러 리포트 문서
//		 	String resultWord[] = resultLyrics.split("\n");			// 한 줄씩 파일에 입력
//		 	for(String word : resultWord){
//		 		resultWriter.write(word);
//		 		resultWriter.newLine();
//		 	}
//		 	resultWriter.close();
	}

}
