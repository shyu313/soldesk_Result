package kr.co.main;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Random;

import javax.management.AttributeList;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dao.DictionaryDAO;
import kr.co.dao.MediaDAO;
import kr.co.dao.SentShareDAO;
import kr.co.dto.DictionaryDTO;
import kr.co.dto.MediaDTO;
import kr.co.dto.SearchDTO;
import kr.co.dto.SentShareDTO;
import kr.co.utility.Utility;
 
@Controller
public class MainController {
	public static Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private DictionaryDAO dicDAO;
	@Autowired
	private MediaDAO mediaDAO;
	@Autowired
	private SentShareDAO dao;
	
	// 결과 확인 http://localhost:9090/test/list.do
	//@RequestMapping(value="index.do", method = RequestMethod.GET)
	@RequestMapping(value="/main/search.do", produces = "application/json; charset=utf8")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Search() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/search");															// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<MediaDTO> musicList= mediaDAO.list();												// media 테이블 전체 노래 정보, 감정단어 검색에도 사용
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 				// bubbleChar data : jsonEmotion 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		List<DictionaryDTO> emotionDICList = dicDAO.selectList("selectList");					// emotionDIC 테이블 감정 단어 정보
		JSONObject jsonBubbleMenu = Utility.getJsonBubbleMenu(emotionDICList);			// BubbleMenu data : jsonEmotion 
		mav.addObject("jsonBubbleMenu",jsonBubbleMenu);
		
		
		
		
		return mav;
	} // Search() end
	
	@RequestMapping(value="/main/search.do", produces = "application/json; charset=utf8", method=RequestMethod.POST )								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Search(String word1, String word2, String word3 ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/search");															// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		List<MediaDTO> musicList= mediaDAO.list();												// media 테이블 전체 노래 정보, 감정단어 검색에도 사용
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 				// bubbleChar data : jsonEmotion 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		List<DictionaryDTO> emotionDICList = dicDAO.selectList("selectList");					// emotionDIC 테이블 감정 단어 정보
		JSONObject jsonBubbleMenu = Utility.getJsonBubbleMenu(emotionDICList);			// BubbleMenu data : jsonEmotion 
		mav.addObject("jsonBubbleMenu",jsonBubbleMenu);
		
		Iterator<DictionaryDTO> emotionDICIterator= emotionDICList.iterator();				// 감정사전에서 키워드 비교
		ArrayList<DictionaryDTO> searchList = new ArrayList<DictionaryDTO>();			// AttributeList() 대신 List<DictionaryDTO> 할당방법? -> ArrayList 사용
		
		String inputWord[] = {word1,word2,word3};
		
		
		
		while(emotionDICIterator.hasNext()){
			DictionaryDTO dto = emotionDICIterator.next();
			String dicWord;
			if(dto.getWord().length()<4){				// 3글자 이상 '~하다' 제거했던  문자열 비교 ex> 위하다		
				dicWord = dto.getWord();
			}else{
				dicWord = dto.getWord().replace("하다","");
			}
			for(String word: inputWord){
				if(dicWord.equals(word)){
					//logger.debug("Emotion : "+dto.getEmotion());
					//logger.debug("word : "+dto.getWord());
					//logger.debug("point : "+dto.getPoint());
					searchList.add(dto);
				}
			}
		}
		
		// 감정별 정렬된 데이터에서 3가지 타입별 9곡 추천 
		Random randomIndex = new Random();														// 감정 타입별로 랜덤 추천
		Utility.categorizeEmotionType(musicList, mediaDAO);											// 다른 클래스에서 DB 접근을 위해 dao 넘김
		
		return mav;
	} // Search() end
	
	// 감성 공유 리스트 컨트롤러
	@RequestMapping("/main/share.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView list(SearchDTO searchDTO, HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/share"); // /main/share.jsp
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		//ArrayList<SentShareDTO> list = dao.list(searchDTO);
		int cnt = dao.getArticleCount(searchDTO);
		
		//페이징
		int numPerPage=10;
		int pagePerBlock=10;
				
		String pageNum=req.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}
				
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*numPerPage+1;
		int endRow=currentPage*numPerPage;
				
		//페이지수
		double totcnt = (double)cnt/numPerPage;
		int totalPage = (int)Math.ceil(totcnt);
				
		double d_page = (double)currentPage/pagePerBlock;
		int Pages = (int)Math.ceil(d_page)-1;
		int startPage = Pages*pagePerBlock;
		int endPage = startPage+pagePerBlock+1;
		
		String word = req.getParameter("word");
		String searchCondition = req.getParameter("searchCondition");
		
		hashMap.put("searchCondition", searchCondition);
		hashMap.put("word", word);
		hashMap.put("startRow", startRow);
		hashMap.put("endRow", endRow);
				
		List<SentShareDTO> articleList=null;
		if(cnt>0){
			articleList=dao.list(hashMap);
		}else{
			articleList=Collections.EMPTY_LIST;
		}
				
		int number=0;
		number=cnt-(currentPage-1)*numPerPage;
				
		//mav.addObject("list", list);
		mav.addObject("count", cnt); // 글 전체 갯수
		
		mav.addObject("number", new Integer(number));
		mav.addObject("pageNum", new Integer(currentPage));
		mav.addObject("startRow", new Integer(startRow));
		mav.addObject("endRow", new Integer(endRow));
		mav.addObject("pageSize", new Integer(pagePerBlock));
		mav.addObject("totalPage", new Integer(totalPage));
		mav.addObject("startPage", new Integer(startPage));
		mav.addObject("endPage", new Integer(endPage));
		mav.addObject("articleList", articleList);
		mav.addObject("word", word);
		mav.addObject("searchCondition", searchCondition);
		
		System.out.println(Pages);
		return mav;
	} // Share() end
	
	// 감성 공유 작성 폼 컨트롤러
	@RequestMapping(value="/main/create.do", method=RequestMethod.GET)
	public ModelAndView createForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/createForm");
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	}
	
	// 감성 공유 처리 컨트롤러
	@RequestMapping(value="/main/create.do", method=RequestMethod.POST)
	public ModelAndView createProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.create(dto);
		mav.setViewName("redirect:/main/share.do"); // /mediagroup/msgView.jsp		
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	}
	
	// 감성 공유 조회 컨트롤러
	@RequestMapping(value="/main/read.do", method=RequestMethod.GET)
	public ModelAndView read(int bbsno){
		dao.readcnt(bbsno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/read");
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}//read() end
	
	// 감성 공유 삭제 폼 컨트롤러 
	@RequestMapping(value="/main/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteForm(int bbsno){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/deleteForm");
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}
	
	// 감성 공유 삭제 처리 컨트롤러
	@RequestMapping(value="/main/delete.do", method=RequestMethod.POST)
	public ModelAndView deleteProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.delete(dto);
		mav.setViewName("redirect:/main/share.do");
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	}
	
	// 감성 공유 수정 폼 컨트롤러
	@RequestMapping(value="/main/update.do", method=RequestMethod.GET)
	public ModelAndView updateForm(int bbsno){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/updateForm");
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		SentShareDTO dto = dao.read(bbsno);
		mav.addObject("dto", dto);
		return mav;
	}
	
	// 감성 공유 수정 처리 컨트롤러
	@RequestMapping(value="/main/update.do", method=RequestMethod.POST)
	public ModelAndView updateProc(SentShareDTO dto){
		ModelAndView mav = new ModelAndView();
		int cnt = dao.update(dto);
		mav.setViewName("redirect:/main/share.do");
		List<MediaDTO> musicList= mediaDAO.list();									//bubbleChart를 보여주기위해  전체 노래 정보 조회 
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(musicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		return mav;
	}
}
