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
		System.out.println("---SentShareDAO°´Ã¼ »ý¼ºµÊ");
	}
	
	public int create(SentShareDTO dto){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt=mapper.create(dto);
		return cnt;
	}
	
	public ArrayList<SentShareDTO> list(){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		ArrayList<SentShareDTO> list = mapper.list();
		return list;
	}
	
	public SentShareDTO read(int bbsno){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		return mapper.read(bbsno);
	}
	
	public int delete(SentShareDTO dto){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt = mapper.delete(dto);
		return cnt;
	}
	
	public int update(SentShareDTO dto){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		int cnt = mapper.update(dto);
		return cnt;
	}
	
	public void readcnt(int bbsno){
		SentMapper mapper = sqlSession.getMapper(SentMapper.class);
		mapper.readcnt(bbsno);
	}
}
