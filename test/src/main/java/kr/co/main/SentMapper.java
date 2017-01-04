package kr.co.main;

import java.util.ArrayList;

import kr.co.main.SentShareDTO;

public interface SentMapper {
	// 인터페이스, 추상메소드로만 존재하며 MyBatis3을 호출하기 편리하도록 지원
	// 매퍼에 들어가는 메소드명은 MyBatis의 XML 파일안의 id와 동일해야 한다 
	// sent.xml
		
	//<select id="list">
	public ArrayList<SentShareDTO> list();
		
	//<insert id="create">
	public int create(SentShareDTO dto);
		
	//<select id="read" parameterType="int" resultType="SentShareDTO">
	public SentShareDTO read(int bbsno);
		
	//<delete id="delete" parameterType="int" resultType="SentShareDTO">
	public int delete(SentShareDTO dto);
		
	public int update(SentShareDTO dto);
	
	public void readcnt(int bbsno);
}
