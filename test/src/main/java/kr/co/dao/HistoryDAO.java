package kr.co.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.dto.HistoryDTO;
import kr.co.music.MusicMapper;

@Component
public class HistoryDAO extends AbstractDAO{

	@Autowired
	private SqlSession sqlSession;		// sql ¹® ½ÇÇà °´Ã¼
	
	public List<HistoryDTO> list(HashMap hashMap){
		MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
		List<HistoryDTO> list = mapper.list(hashMap);
		return list;
	}
	
	public List<HistoryDTO> datelist(){
		MusicMapper mapper = sqlSession.getMapper(MusicMapper.class);
		List<HistoryDTO> list = mapper.datelist();
		return list;
	}
}
