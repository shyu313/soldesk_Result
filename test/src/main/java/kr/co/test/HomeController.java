package kr.co.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/index.do")
	public ModelAndView index() throws IOException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		String	videoId = "OxgiiyLp5pk"; 	// 야생화 고정
		BufferedReader  reader = new BufferedReader(new FileReader("C:/Users/all/Desktop/야생화가사.txt"));
		String lyrics="";
		String line="";
		while((line = reader.readLine()) != null) 
		{
			lyrics += line+"\n";
		}
		mav.addObject("videoId", videoId);
		mav.addObject("lyrics", lyrics);
		
		return mav;
	} // index() end
}
