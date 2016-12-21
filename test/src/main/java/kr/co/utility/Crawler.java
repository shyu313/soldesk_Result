package kr.co.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {
	public static Document crawl(String url) throws ClientProtocolException, IOException {
   
		HttpPost http = new HttpPost(url); // 가져올 HTTP 주소 세팅
		HttpClient httpClient = HttpClientBuilder.create().build();		// 가져오기를 실행할 클라이언트 객체생성
		HttpResponse response = httpClient.execute(http); 				// 실행 및 실행 데이터를 Response 객체에 담음
		HttpEntity entity = response.getEntity(); 						// Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음

		ContentType contentType = ContentType.getOrDefault(entity); 	// Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고Charset을 가져옴
		Charset charset = contentType.getCharset();

		BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset)); // DOM데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream Buffered 중 선택은 개인취향)
		StringBuffer sb = new StringBuffer(); 							// 가져온 DOM 데이터를 담기위한 그릇

		String line = ""; // DOM 데이터 가져오기
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		Document doc = Jsoup.parse(sb.toString()); // Jsoup으로 파싱

		return doc;
	} // crawl() end

	public void getMusicContents() throws ClientProtocolException, IOException {
		System.out.println(" Start Date : " + Utility.getCurrentDate());	// 가져오기전 시간 찍기
		int no = 0;

		for (no = 1; no <= 1; no++) {
			String url = "http://gasazip.com/" + no;
			Document doc = crawl(url);
			try {
				String subject = doc.select("div.col-md-8").get(0).text(); 	// 제목
				String lyrics = doc.select("div.col-md-8").get(1).text(); 	// 가사
				String singer = doc.select("div.col-md-4").get(0).text();	// 가수
				String album ="";
				
				if(singer.contains("집")){									// 앨범 
					album = singer.substring(singer.indexOf(":")+2, singer.indexOf("집")+1);	// 공백제외
				
				}
				
				if (singer.contains("Unknown")) {							// 가수가 없는 경우 예외처리
					System.out.println(no + " is pass");
					continue;
				}
				
				BufferedWriter out = new BufferedWriter(new FileWriter("./lyrics/" + no + ".txt")); // 출력파일 만들기 : 번호.txt
				out.write("제목 : " + subject);
				out.newLine(); 
				out.write("가수 : "+ singer);
				out.newLine();
				out.write(lyrics);
				out.newLine();
				out.write(getYoutubeURL(subject, singer, album));
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // getcontents() end
	
	public String getYoutubeURL(String subject, String singer, String album) throws ClientProtocolException, IOException {
		
		//youtube url 가져오기 (*함수형으로)
		
		String searchSubject = subject.replace(" ", "+");
		String url = "https://www.youtube.com/results?search_query=" + searchSubject + "+" + singer + "+" + album; // youtube 검색 결과 url
		Document doc = crawl(url);
		
		// 결과 중 목록 형태가 아닌 하나의 영상이 연결된 링크 부분 가져오기
		String[] varray = doc.select("div.contains-addto a").toString().split(" "); // contains-addto - 음악 재생 페이지
		String resultValue="";
		for(int idx=0; idx<varray.length; idx++) {
			if(varray[idx].length()>6) {
				if(varray[idx].substring(0,4).equals("href")) {
					resultValue = varray[idx].substring(6, 26); // 링크의 주소부분 추출
				}
			}
			if(!resultValue.isEmpty()) // 링크주소를 얻고나면 빠져나오기
				break; 
		}
		return "https://www.youtube.com"+ resultValue;	// 제일 첫번째 결과의 url
	}
} // class end
