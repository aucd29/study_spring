package com.ex.board2;

import java.util.ArrayList;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.board2.data.BoardVo;
import com.ex.board2.db.BoardDao;


@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDao mBoardDao;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Locale locale, Model model) {
		return "add";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String process(Locale locale, Model model, 
			@RequestParam("title") String title, 
			@RequestParam("writer") String writer,
			@RequestParam("content") String content) {

		logger.info("=====================");
		logger.info("title   : " + title);
		logger.info("writer  : " + writer);
		logger.info("content : " + content);
		logger.info("=====================");
		
		try {
			mBoardDao.save(new BoardVo(title, writer, content, 0));
		} catch (Exception e) {
			return processError(model, e);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.PUT)
	public String process(Locale locale, Model model, 
			@RequestParam("id") int id,
			@RequestParam("title") String title, 
			@RequestParam("writer") String writer,
			@RequestParam("content") String content) {

		logger.info("=====================");
		logger.info("id     : " + id);
		logger.info("title   : " + title);
		logger.info("writer  : " + writer);
		logger.info("content : " + content);
		logger.info("=====================");
		
		try {
			mBoardDao.save(new BoardVo(id, title, writer, content, 0));
		} catch (Exception e) {
			return processError(model, e);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Locale local, Model model, 
			@RequestParam("id") int id) {
		
		logger.info("=====================");
		logger.info("id : " + id);
		logger.info("=====================");
		
		try {
			BoardVo vo = mBoardDao.get(id); 	// seq == id
			model.addAttribute("vo", vo);
			model.addAttribute("modify", 1);
		} catch (Exception e) {
			return processError(model, e);
		}
		
		return "add";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.DELETE)
	public String process(Locale locale, Model model, 
			@RequestParam("id") int id) {

		logger.info("=====================");
		logger.info("id     : " + id);
		logger.info("=====================");
		
		try {
			mBoardDao.delete(id);
		} catch (Exception e) {
			return processError(model, e);
		}
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		ArrayList<BoardVo> list;
		
		try {
			list = mBoardDao.list();
		} catch (Exception e) {
			return processError(model, e);
		}
		
		logger.info("=====================");
		logger.info("list : " + list.size());
		logger.info("=====================");
		
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Locale locale, Model model, 
			@RequestParam("id") int id) {
		logger.info("=====================");
		logger.info("id : " + id);
		logger.info("=====================");
		
		try {
			BoardVo vo = mBoardDao.get(id); 	// seq == id
			model.addAttribute("vo", vo);
		} catch (Exception e) {
			return processError(model, e);
		}
		
		return "read";
	}
	
	private String processError(Model model, Exception e) {
		model.addAttribute("error_msg", e.getMessage());
		return "error";
	}
}
