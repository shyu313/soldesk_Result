package kr.co.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.dto.DictionaryDTO;

@Component
public class DictionaryDAO extends AbstractDAO{

	@Override
	public List<DictionaryDTO> selectList(String queryId) {		// 전체 감정 단어 조회
		return super.selectList(queryId);
	}
	
}
