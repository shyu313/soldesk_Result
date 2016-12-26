package kr.co.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		try {
			BufferedReader  dicWordReader = new BufferedReader(new FileReader("./dictionary/dictionaryword.txt"));
			BufferedReader  lyricsReader = new BufferedReader(new FileReader("./lyrics.txt"));
			BufferedWriter dicWordWriter = new BufferedWriter(new FileWriter("./dictionary/Exception word_range.txt"));				// 에러 리포트 문서 
			String dicWord ="";				// 감정단어사전에 포함될 단어 
			String lyrics ="";
			String line ="";
			// 제외시킬 단어를 읽기
			while((line = dicWordReader.readLine()) != null) 
			{
				dicWord += line+" ";
				//System.out.println(line);
			}
			int count =0;
			// 전체 가사 파일 읽기
			while((line = lyricsReader.readLine()) != null) 
			{
				lyrics += line+"\n";
				System.out.println(count);
				count++;
			}
			
			dicWordReader.close();
			lyricsReader.close();
			
			// 감정단어 제외 시키기 
		 	String removeWord[] = dicWord.split(" ");
		 	String resultLyrics = "";
		 	count=0;
		 	System.out.println("감정단어 제외 시작");
		 	for(String remove : removeWord){
		 		lyrics =  lyrics.replace(remove, "");
		 		System.out.println(count);
		 		count++;
		 		
			}
		 	
		 	resultLyrics = lyrics;
		 	
		 	System.out.println("감정단어 제외 결과");
		 	BufferedWriter resultWriter = new BufferedWriter(new FileWriter("./emotion/exceptionWord.txt"));				// 에러 리포트 문서
		 	String resultWord[] = resultLyrics.split("\n");			// 한 줄씩 파일에 입력
		 	for(String word : resultWord){
		 		resultWriter.write(word);
		 		resultWriter.newLine();
		 	}
		 	resultWriter.close();
		 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
