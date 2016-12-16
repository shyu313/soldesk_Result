package kr.co.test;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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


public class Ktest {
	
	public static String getCurrentData(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return sdf.format(new Date());
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		// 1. 가져오기전 시간 찍기
		System.out.println(" Start Date : " + getCurrentData());
		
		
		//
		
		for(int no=1;no<=2;no++){
		// 2. 가져올 HTTP 주소 세팅
	    HttpPost http = new HttpPost("http://gasazip.com/"+no);

	    // 3. 가져오기를 실행할 클라이언트 객체 생성
	    HttpClient httpClient = HttpClientBuilder.create().build();
	    
	    // 4. 실행 및 실행 데이터를 Response 객체에 담음
	    HttpResponse response = httpClient.execute(http);
	    
	    // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
	    HttpEntity entity = response.getEntity();
	    
	    // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴 
	    ContentType contentType = ContentType.getOrDefault(entity);
        Charset charset = contentType.getCharset();
        
        // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향) 
	    BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
	    
	    // 8. 가져온 DOM 데이터를 담기위한 그릇
	    StringBuffer sb = new StringBuffer();
	    
	    // 9. DOM 데이터 가져오기
	    String line = "";
	    while((line=br.readLine()) != null){
	    	sb.append(line+"\n");
	    }
	    
	    // 10. 가져온 아름다운 DOM을 보자
	    //System.out.println(sb.toString());
	    
	    // 11. Jsoup으로 파싱해보자.
	    Document doc = Jsoup.parse(sb.toString());
	    
	    
	    System.out.println(doc.select("div.col-md-8"));
	    String gasa = doc.select("div.col-md-8").toString();
	    
	    
	    /*
	 // 파일 출력하기
	 		try {
	 			String fileName="D:/java0802/song.txt";
	 			// 출력 파일이 없으면 생성
	 			// append: true 추가, false 겹쳐쓰기(overwrite)
	 			FileWriter fw=new FileWriter(fileName,false);
	 			PrintWriter out=new PrintWriter(fw, true);  // true 버퍼 클리어
	 			out.println(doc.select("div.col-md-8"));

	 			out.close();
	 			fw.close();
	 			System.out.println("데이터 파일 생성 완료!!");
	 			
	 		}catch(Exception e){
	 			System.out.println("파일 읽기 실패!!  "+e);
	 		}
	    */
		}
	    
	    // 12. 얼마나 걸렸나 찍어보자
	    System.out.println(" End Date : " + getCurrentData());
	}
}
