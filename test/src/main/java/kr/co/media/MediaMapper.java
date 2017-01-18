package kr.co.media;

import java.util.HashMap;
import java.util.List;

import kr.co.dto.mediaDTO;

public interface MediaMapper {
		//<select id="list">
		public List<mediaDTO> list(HashMap hashMap);
			
		//<insert id="create">
		public int create(mediaDTO dto);
			
		//<select id="read" parameterType="int" resultType="SentShareDTO">
		public mediaDTO read(int bbsno);
			
		//<delete id="delete" parameterType="int" resultType="SentShareDTO">
		public int delete(mediaDTO dto);
			
		public int update(mediaDTO dto);
		
		public void readcnt(int bbsno);
}
