package com.ex.board3;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ex.board3.model.BoardVo;
import com.ex.board3.model.IBoardMapper;

@Service
public class BoardService {
	@Autowired
	IBoardMapper mapper;

	public void save(BoardVo vo) {
		mapper.save(vo);
	}

	public ArrayList<BoardVo> list() {
		ArrayList<BoardVo> list = mapper.list();
		
		return list;
	}

	public BoardVo get(int id) {
		return mapper.get(id);
	}

	public void update(BoardVo vo) {
		mapper.update(vo);
	}

	public void delete(int id) {
		mapper.delete(id);
	}
}
