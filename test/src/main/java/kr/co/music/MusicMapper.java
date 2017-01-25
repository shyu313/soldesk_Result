package kr.co.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.dto.HistoryDTO;
import kr.co.dto.HistorySearchDTO;

public interface MusicMapper {
		//<select id="list">
		public List<HistoryDTO> list(HashMap hashMap);					// 노래 전체 리스트
		
		public List<HistorySearchDTO> datelist(HashMap hashMap);					// 노래 전체 리스트
}
