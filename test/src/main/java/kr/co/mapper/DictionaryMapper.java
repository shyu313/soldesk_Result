package kr.co.mapper;

import java.util.List;

import kr.co.dto.MediaDTO;

public interface DictionaryMapper {
	//<select id="list">
	public List<MediaDTO> selectList();					// 감정사전 전체 리스트

}
