package kr.co.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.dto.DictionaryDTO;
import kr.co.dto.HistoryDTO;
import kr.co.dto.MediaDTO;
import kr.co.media.MediaMapper;

@Component
public class MediaDAO extends AbstractDAO{

	@Autowired
	private SqlSession sqlSession;		// sql 문 실행 객체
	
		// 노래 가사 등록
		public int create(MediaDTO dto){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			int cnt=mapper.create(dto);
			return cnt;
		}
		
		
		// 노래 조회 리스트
		public List<MediaDTO> list(){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			List<MediaDTO> list = mapper.list();
			return list;
		}
		// 감정별 노래 조회 리스트
		public ArrayList<MediaDTO> listOfEmotionTpye(HashMap<String, String> emotionType){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			ArrayList<MediaDTO> list = mapper.listOfEmotionTpye(emotionType);
			return list;
		}
		
		// 노래 top10 조회 리스트
		public List<MediaDTO> toplist(){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			List<MediaDTO> toplist = mapper.toplist();
			return toplist;
		}
		// 감정단어 조회 결과 리스트
		public List<MediaDTO> searchEmotionList(ArrayList<DictionaryDTO> paramDICList){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			List<MediaDTO> searchEmotionList = mapper.searchEmotionList(paramDICList);
			return searchEmotionList;
		}
		
		// RandomPlay 리스트
		public List<MediaDTO> randomList(){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			List<MediaDTO> randomList = mapper.randomList();
			return randomList;
		}
	/*	// emotionMusicList 리스트
		public List<MediaDTO> emotionmusiclist(){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			List<MediaDTO> randomList = mapper.();
			return randomList;
		}*/

		
		
		// 노래 조회
		public MediaDTO read(int lyricNo){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			return mapper.read(lyricNo);
		}
		
		// 노래 삭제
		public int delete(MediaDTO dto){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			int cnt = mapper.delete(dto);
			return cnt;
		}
		
		// 노래 수정
		public int update(MediaDTO dto){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			int cnt = mapper.update(dto);
			return cnt;
		}
		
		// 조회수 증가
		public void readcnt(int lyricNo){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			mapper.readcnt(lyricNo);
		}
		 
		//재생횟수 증가
		public void playcnt(int lyricNo){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			mapper.playcnt(lyricNo);
		}

		public void dateinsert(HashMap hashMap){
			MediaMapper mapper = sqlSession.getMapper(MediaMapper.class);
			mapper.dateinsert(hashMap);
		}
}
