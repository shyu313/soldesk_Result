package kr.co.music;
 
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import au.com.bytecode.opencsv.CSVWriter;
import kr.co.dao.HistoryDAO;
import kr.co.dao.MediaDAO;
import kr.co.dto.HistoryDTO;
import kr.co.dto.HistorySearchDTO;
import kr.co.dto.MediaDTO;
import kr.co.utility.Utility;
@Controller
public class MusicController {
	public static Logger logger = LoggerFactory.getLogger(MusicController.class);
	@Autowired
	HistoryDAO historyDAO;
	
	@Autowired
	MediaDAO mediaDAO;

	@RequestMapping("/music/replay.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Replay(HistoryDTO historyDTO) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/replay");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		String username = "Ciel Lu";
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("username", username);
		
		List<MediaDTO> mumusicList= mediaDAO.list();			
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(mumusicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		List<HistoryDTO> musicList= historyDAO.list(hashMap);		
		mav.addObject("list",musicList);

		return mav;
	} // Replay() end
	
	@RequestMapping("/music/emotionlist.do")								// .do가 안됬던 이유 : 패키지명 test를 제외한 경로 입력
	public ModelAndView Emotionlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("music/emotionlist");								// .jsp 는 suffix 에 지정했으므로 제외시켜도 된다.
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		List<MediaDTO> mumusicList= mediaDAO.list();			
		JSONObject jsonEmotion = Utility.getJsonAllEmotionMusic(mumusicList);	 
		mav.addObject("jsonEmotion",jsonEmotion);
		
		List<HistorySearchDTO> musicList= historyDAO.datelist(hashMap);	

		
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String,Object>>();

		Map<String, Object> hmap = null;
		hmap = new HashMap<String, Object>();
        hmap.put("day", "day");
        hmap.put("hour", "hour");
        hmap.put("value", "value");
        list.add(hmap);
        
        for(int i=0; i<musicList.size(); i++){
			HistorySearchDTO dto =musicList.get(i);
			if("happy".equals(dto.getEmotion()))
			{
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 1);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
			else if("sad".equals(dto.getEmotion()))
			{
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 2);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
			else if("rage".equals(dto.getEmotion()))
			{
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 3);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
			else if("disgust".equals(dto.getEmotion()))
			{
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 4);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
			else if("interest".equals(dto.getEmotion()))
			{
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 5);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
			else if("pain".equals(dto.getEmotion()))
			{
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 6);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
			else if("fear".equals(dto.getEmotion()))
			{ 
				hmap = new HashMap<String, Object>();
	            hmap.put("day", 7);
	            hmap.put("hour", dto.getTime());
	            hmap.put("value", dto.getValue());
	            list.add(hmap);
			}
		}
        
        for(int i=1;i<8;i++)
	    {
	    	for(int j=1;j<25;j++)
	    	{
	    		hmap = new HashMap<String, Object>();
	            hmap.put("day", i);
	            hmap.put("hour", j);
	            hmap.put("value", 0);
	            list.add(hmap);
	    	}
	    }
	    
		try {
            CSVWriter cw = new CSVWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\soldesk\\git\\soldesk_Team_1\\test\\src\\main\\webapp\\music\\data.csv"), "UTF-8"),',', '"');
            try {
                for(Map<String, Object> m : list) {
                    //배열을 이용하여 row를 CSVWriter 객체에 write
                    cw.writeNext(new String[] { String.valueOf(m.get("day")),String.valueOf(m.get("hour")),String.valueOf(m.get("value"))});
                }  
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //무조건 CSVWriter 객체 close
                cw.close();
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		mav.addObject("datelist",musicList);					

		return mav;
	} // Emotionlist() end
}


