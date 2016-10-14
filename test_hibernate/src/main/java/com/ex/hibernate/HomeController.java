package com.ex.hibernate;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BoardDao dao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		
		try {
			List<BoardVo> list = dao.list();
			for (BoardVo vo : list) {
				logger.info("vo id      : " + vo.getId());
				logger.info("vo title   : " + vo.getTitle());
				logger.info("vo writer  : " + vo.getWriter());
				logger.info("vo content : " + vo.getContent());
				logger.info("vo date    : " + vo.getDate());
				logger.info("vo count   : " + vo.getCount());
				logger.info(" === ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "home";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		BoardVo vo = new BoardVo();
		vo.setTitle("hello");
		vo.setWriter("world");
		vo.setContent("hibernate test");
		
		dao.save(vo);
		
		return "redirect:/";
	}

}
