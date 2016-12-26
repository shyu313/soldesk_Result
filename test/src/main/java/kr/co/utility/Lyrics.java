package kr.co.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;


/*
 * 가사 관련 메소드
 * 
 * 1. 누락된 가사 구분  
 * 
 */

public class Lyrics {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		countLyrics();
	}
	
	// lyrics 폴더내 누락된 가사 번호 찾기
	public static void countLyrics() throws IOException{
		int startNo = 192614;
		int finishNo = 400000;
		int count =1;
		String omissionLyricsNo="";
		BufferedReader reader=null;
		
		// 파일 유무 확인 
		for(int no = startNo; no<finishNo; no++ ){
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
		writer.write("총 계수 : "+ count);
		writer.close();		// 모든 번호를 저장한 뒤 닫기
		
		System.out.println("누락 총계 : "+ count);
	}
}
