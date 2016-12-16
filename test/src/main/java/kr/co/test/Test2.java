package kr.co.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test2 {

	public static String getCurrentData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// 1. 가져오기전 시간 찍기
		System.out.println(" Start Date : " + getCurrentData());
		int no = 1;

		for (no = 1; no <= 1; no++) {
			// 2. 가져올 HTTP 주소 세팅
			HttpPost http = new HttpPost("http://gasazip.com/" + no + "");

			// 3. 가져오기를 실행할 클라이언트 객체 생성
			HttpClient httpClient = HttpClientBuilder.create().build();

			// 4. 실행 및 실행 데이터를 Response 객체에 담음
			HttpResponse response = httpClient.execute(http);

			// 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
			HttpEntity entity = response.getEntity();

			// 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴
			ContentType contentType = ContentType.getOrDefault(entity);
			Charset charset = contentType.getCharset();

			// 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중
			// 선택은 개인취향)
			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));

			// 8. 가져온 DOM 데이터를 담기위한 그릇
			StringBuffer sb = new StringBuffer();

			// 9. DOM 데이터 가져오기
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			// 10. 가져온 DOM을 보자
			// System.out.println(sb.toString());

			// 11. Jsoup으로 파싱해보자.
			Document doc = Jsoup.parse(sb.toString());
			// System.out.println(doc.select("div.col-md-8"));
			try {
				String content = doc.select("div.col-md-8").toString(); // 제목, 가사 부분
				String[] carray = content.split(">");
				String subject = carray[2].substring(0, carray[2].length() - 4); // 제목 분리
				String[] sarray = doc.select("div.col-md-4").toString().split(">"); // 가수 부분 추출
				String[] ssarray = sarray[1].substring(3, sarray[1].length() - 7).split(" ");
				String singer = ssarray[0]; // 가수 부분의 첫 번째 띄어쓰기 앞의 단어만 추출 -> 검색에 이용
				// 예외처리
				if(singer.equals("Unknown")) {
					System.out.println(no+" is pass");
					continue;
				}
				// 앨범 '~집' 이란 단어가 있는 경우 album 값으로 저장
				String album="";
				for(int idx=0; idx<ssarray.length; idx++) {
					if(ssarray[idx].equals("앨범")) {
						for(int i=idx+2; i<ssarray.length; i++) {
							if(ssarray[i].substring(ssarray[i].length()-1, ssarray[i].length()).equals("집")) {
								album=ssarray[i];
								break;
							}
						}
						break;
					}
				}
				
				// youtube url 가져오기 (*함수형으로)
				String searchSubject = subject.replace(" ", "+");
				String url = "https://www.youtube.com/results?search_query=" + searchSubject + "+" + singer + "+" + album; // youtube 검색 결과 url
				http = new HttpPost(url);
				httpClient = HttpClientBuilder.create().build();
				response = httpClient.execute(http);
				entity = response.getEntity();
				contentType = ContentType.getOrDefault(entity);
				charset = contentType.getCharset();
				br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
				sb = new StringBuffer();
				line = "";
				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				doc = Jsoup.parse(sb.toString());
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
				String sourceUrl = "https://www.youtube.com"+ resultValue; // 제일 첫번째 결과의 url
				
				BufferedWriter out = new BufferedWriter(new FileWriter("./lyrics/" + no + ".txt")); // 출력파일 만들기 : 번호.txt
				// 출력파일 내용
				out.write("제목 : " + subject);
				out.newLine(); 
				out.write("가수 : " + sarray[1].substring(3, sarray[1].length() - 7));
				out.newLine();
				for (int i = 6; i < carray.length; i++) {
					// 가사
					out.write(carray[i].substring(0, carray[i].length() - 7));
					out.newLine();
				} 
				out.write(sourceUrl);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 12. 얼마나 걸렸나 찍어보자
		System.out.println(" End Date : " + getCurrentData());
	}
}
