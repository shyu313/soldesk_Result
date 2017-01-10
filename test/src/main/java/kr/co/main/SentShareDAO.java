package kr.co.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SentShareDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public SentShareDAO() {
		System.out.println("---SentShareDAO객체 생성됨");
	}
	 
	// 감성 공유 작성
	public int create(SentShareDTO dto){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt=mapper.create(dto);
		return cnt;
	}
	
	// 감성 공유 목록
	public ArrayList<SentShareDTO> list(SearchDTO searchDTO){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		ArrayList<SentShareDTO> list = mapper.list(searchDTO);
		return list;
	}
	
	// 감성 공유 조회
	public SentShareDTO read(int bbsno){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		return mapper.read(bbsno);
	}
	
	// 감성 공유 삭제
	public int delete(SentShareDTO dto){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt = mapper.delete(dto);
		return cnt;
	}
	
	// 감성 공유 수정 
	public int update(SentShareDTO dto){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt = mapper.update(dto);
		return cnt;
	}
	
	// 조회수 증가
	public void readcnt(int bbsno){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		mapper.readcnt(bbsno);
	}
	
	// 글 전체 갯수
	public int getArticleCount(SearchDTO searchDTO){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt = mapper.getArticleCount(searchDTO);
		return cnt;
	}
}
