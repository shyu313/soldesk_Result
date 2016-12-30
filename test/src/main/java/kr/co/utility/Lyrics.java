package kr.co.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
/*
 * 가사 관련 메소드
 * 
 * 1. 누락된 가사 검색 기능	:	countLyrics(int, int)
 * 2. 팝송 가사 구분 기능		:	searchPOP(int, int)
 * 3.  파일 쓰기 함수			:    lyricsWrite(String, String, int )
 */

public class Lyrics {
	 
	public static void main(String[] args) throws ClientProtocolException, IOException {
		int startNo=100618, finishNo=100700;
		//countLyrics();
		searchPOP(startNo, finishNo);
		
	}
	
	// lyrics 폴더내 누락된 가사 번호 찾기
	public static void countLyrics(int startNo, int finishNo) throws IOException{
		// 19만~ 50만  : 31만개 스캔
		int count =1;
		String omissionLyricsNo="";
		BufferedReader reader=null; 
		
		// 파일 유무 확인 
		for(int no = startNo; no<=finishNo; no++ ){
			try {
				reader = new BufferedReader(new FileReader("./lyrics/"+no+".txt"));
			} catch (FileNotFoundException e) {								// 누락된 파일 
				System.out.println("누락된 가사 번호 : " + no);
				omissionLyricsNo += no+"/";
				count++;
				reader.close();
			}
		};
		
		// 누락된 가사 저장
		BufferedWriter writer = new BufferedWriter(new FileWriter("./errorReport/omissionLyrics.txt"));	
		String result[] = omissionLyricsNo.split("/");
		for(String omissionNo : result){
	 		writer.write(omissionNo);
	 		writer.newLine();
	 	}
		writer.close();		// 모든 번호를 저장한 뒤 닫기
		
		System.out.println("누락 총계 : "+ count);
	}
	
	// 62만개 중에서 팝송 가사 구분 
	public static void searchPOP(int startNo, int finishNo) throws IOException{
		BufferedReader  lyricsReader=null;	// 가사 읽기
		String lyrics ="";							// 전체 가사 
		String line ="";							// 파일단위 읽기
		
		for(int no = startNo; no <= finishNo; no++){										// 가사를 스캔하면서 영어/한글(일본,한자,특수무자 포함) 노래 구분 하기  
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
					lyrics += line+"\n";		// 전체 가사를 저장할 때, 영어는 따로 저장하자 			 					
				} 
				//System.out.println("Lyrics : "+lyrics);
				
				String replaceLyrics =lyrics.replace(" ","").replace(",", "").replace("'", "").replace("?", "").replace("/",	 "").replace("(","").replace(")","").replace("-","").replace("~","");	// 특수문자 제외
				koreaWordCount = replaceLyrics.length()-englishWordCount;		//  알파벳 / 한국어(일본,한자) 구분
				
				
				System.out.println(" 한글 수(그 외 문자포함)  : " + koreaWordCount);
				System.out.println(" 알파벳 수 : " + englishWordCount);
				
				if( koreaWordCount > englishWordCount || koreaWordCount >=150){			// 1.  알파벳 외 문자수가 더 많거나, 50자 이상인 경우 팝송일 확률이 낮음
					System.out.println("이 노래는 영어 노래가 아닙니다.");
					lyricsWrite("koreaLyrics", lyrics , no);
				
				}else if(replaceLyrics.length()<150){														// 2. 가사에 문자수가 150 미만인 경우 가사가 없는걸로 판단, 제외시킴
					System.out.println("이 노래는 가사가 없습니다.");
					lyricsWrite("emptyLyrics", lyrics, no);
				}else{
					System.out.println("이 노래는 영어 노래 입니다.");									// 3. 알파벳을 많이 포함한 가사인 경우 팝송일 확률이 높다.
					lyricsWrite("englishLyrics", lyrics, no);
				}
				
				lyricsReader.close();
				lyrics="";
				
			} catch (FileNotFoundException e) {
				System.out.println("누락된 가사부분은 pass");
			}
		}
	}
	
	// 파일 쓰기 함수 ( 팝송, 한국노래, 가사가 없는 노래 구분해서 폴더에 저장)
	public static void lyricsWrite(String folder, String lyrics,  int no) throws IOException{
		BufferedWriter   writer = null;
		writer = new BufferedWriter(new FileWriter("./"+folder+"/"+no+".txt"));		// 팝송 노래 저장
		String writeLine[] = lyrics.split("\n");
	 	
		for(String line2 : writeLine){
	 		writer.write(line2);
	 		writer.newLine();
	 	}
	 	writer.close();
	}
	
}
