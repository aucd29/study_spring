package com.ex.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public List<BoardVo> list() {
		return dao.list();
	}
}
