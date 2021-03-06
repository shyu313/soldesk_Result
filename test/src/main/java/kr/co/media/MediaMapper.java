package kr.co.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.dto.DictionaryDTO;
import kr.co.dto.HistoryDTO;
import kr.co.dto.MediaDTO;

public interface MediaMapper {
		//<select id="list">
		public List<MediaDTO> list();							// 노래 전체 리스트
		public List<MediaDTO> toplist();						// top10 리스트
		public ArrayList<MediaDTO> listOfEmotionTpye(HashMap<String, String> emotionType);		// 감정별 노래 조회 리스트
		public List<MediaDTO> searchEmotionList(ArrayList<DictionaryDTO> paramDICList);			// 감정검색 결과 리스트
		public List<MediaDTO> randomList();
		
		
		//<insert id="create">
		public int create(MediaDTO dto);
		public void dateinsert(HashMap hashMap);
		
		//<select id="read" parameterType="int" resultType="SentShareDTO">
		public MediaDTO read(int lyricsNo);
			
		//<delete id="delete" parameterType="int" resultType="SentShareDTO">
		public int delete(MediaDTO dto);
			
		public int update(MediaDTO dto);
		
		public void readcnt(int bbsno);
		public void playcnt(int lyricNo);
}
