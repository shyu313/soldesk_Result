package kr.co.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.dto.HistoryDTO;

public interface MusicMapper {
		//<select id="list">
		public List<HistoryDTO> list(HashMap hashMap);					// 노래 전체 리스트
		
		public List<HistoryDTO> datelist();					// 노래 전체 리스트
}
