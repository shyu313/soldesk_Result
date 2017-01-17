package kr.co.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.utility.DBOpen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class JsonTest {

	public static void main(String[] args) {
		DBOpen dbopen = new DBOpen();
		
		/*
		// 최종 완성될 JSONObject 선언(전체)
		JSONObject jsonObject = new JSONObject();
		// person의 JSON정보를 담을 Array 선언
		JSONArray top10Array = new JSONArray();
		// person의 한명 정보가 들어갈 JSONObject 선언
		JSONArray state = new JSONArray();
		JSONObject freq = new JSONObject();
		JSONObject emotion = new JSONObject();
		String top = "탑1";
		*/
		
		Connection con=null;
		PreparedStatement pstmt = null;
		StringBuffer sql = null;
		ResultSet rs = null;
		con = dbopen.getConnetion();
		sql=new StringBuffer();
		sql.append(" select * from bardciel.media order by playCnt desc limit 0,10 ");
		
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println(rs.toString());
			}
			System.out.println("@@@@@@@@@@@@@@@@@@");
				
		} catch (SQLException e) {
		}
		/*
		emotion.put("happy", 7);
		emotion.put("sad", 6);
		emotion.put("rage", 5);
		emotion.put("disgust", 4);
		emotion.put("interest", 3);
		emotion.put("pain", 2);
		emotion.put("fear", 1);
		
		
		freq.put("freq", emotion);
		state.add(top);
		state.add(freq);
		
		
		top10Array.add(state);
		*/
/*	System.out.println(top10Array);*/
		/*System.out.println(	state.get(0) );
		String str	 = state.get(1).toString();
		str=str.replace("\"",	"");
		str=str.substring(1, str.length()-1);
		System.out.println(	str );*/
		
		
		// 정보 입력
		
		/*freq.put("happy", "10");
		freq.put("sad", "10");
		freq.put("rage", "12");
		freq.put("disgust", "11");
		// Array에 입력
		personArray.add(freq);
*/
		
		
		// 전체의 JSONObject에 사람이란 name으로 JSON의 정보로 구성된 Array의 value를 입력
		//jsonObject.put("State", personArray);

		//JSONArray bookArray = new JSONArray();

		/*JSONObject bookInfo = new JSONObject();
		bookInfo.put("name", "사람은 무엇으로 사는가?");
		bookInfo.put("writer", "톨스토이");
		bookInfo.put("price", "100");
		bookInfo.put("genre", "소설");
		bookInfo.put("publisher", "톨스토이 출판사");
		bookArray.add(bookInfo);

		bookInfo = new JSONObject();
		bookInfo.put("name", "홍길동전");
		bookInfo.put("writer", "허균");
		bookInfo.put("price", "300");
		bookInfo.put("genre", "소설");
		bookInfo.put("publisher", "허균 출판사");
		bookArray.add(bookInfo);

		bookInfo = new JSONObject();
		bookInfo.put("name", "레미제라블");
		bookInfo.put("writer", "빅토르 위고");
		bookInfo.put("price", "900");
		bookInfo.put("genre", "소설");
		bookInfo.put("publisher", "빅토르 위고 출판사");
		bookArray.add(bookInfo);*/

		//jsonObject.put("books", bookArray);

		// JSONObject를 String 객체에 할당
	/*	String jsonInfo = jsonObject.toJSONString();

		System.out.print(jsonInfo);*/

	}

}
