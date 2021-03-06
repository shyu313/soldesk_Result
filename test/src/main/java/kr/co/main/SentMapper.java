package kr.co.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.dto.SearchDTO;
import kr.co.dto.SentShareDTO;

// 감성 공유 매퍼(Mapper).
public interface SentMapper {
	// 인터페이스, 추상메소드로만 존재하며 MyBatis3을 호출하기 편리하도록 지원
	// 매퍼에 들어가는 메소드명은 MyBatis의 XML 파일안의 id와 동일해야 한다 
	// sent.xml
	
	//<select id="list">
	public List<SentShareDTO> list(HashMap hashMap);  // 감성 공유 목록 
		
	//<insert id="create">
	public int create(SentShareDTO dto);
		
	//<select id="read" parameterType="int" resultType="SentShareDTO">
	public SentShareDTO read(int bbsno);
		
	//<delete id="delete" parameterType="int" resultType="SentShareDTO">
	public int delete(SentShareDTO dto);
		
	public int update(SentShareDTO dto);
	
	public void readcnt(int bbsno);
	
	public int getArticleCount(SearchDTO searchDTO); // 글 전체 갯수
}
