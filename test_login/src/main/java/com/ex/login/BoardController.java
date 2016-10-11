package com.ex.login;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.login.data.BoardVo;


@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	ArrayList<BoardVo> mBoardList = new ArrayList<BoardVo>();
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Locale locale, Model model) {
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String process(Locale locale, Model model, 
			@RequestParam("title") String title, 
			@RequestParam("writer") String writer,
			@RequestParam("content") String content) {

		int seq = mBoardList.size() + 1;
		
		logger.info("=====================");
		logger.info("seq     : " + seq);
		logger.info("title   : " + title);
		logger.info("writer  : " + writer);
		logger.info("content : " + content);
		logger.info("=====================");
		
		mBoardList.add(new BoardVo(seq, title, writer, content, 0));
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		logger.info("=====================");
		logger.info("list : " + mBoardList.size());
		logger.info("=====================");
		
		model.addAttribute("list", mBoardList);
		
		return "list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Locale locale, Model model, 
			@RequestParam("seq") int seq) {
		logger.info("=====================");
		logger.info("seq : " + seq);
		logger.info("=====================");
		
		BoardVo vo = mBoardList.get(seq - 1);
		model.addAttribute("vo", vo);
		
		return "read";
	}
}
