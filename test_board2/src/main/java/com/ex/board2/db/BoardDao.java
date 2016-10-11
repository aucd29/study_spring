package com.ex.board2.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ex.board2.data.BoardVo;

public class BoardDao implements IBoardDao {
	private final String SQL_ADD    = "INSERT INTO board (id, title, writer, content) VALUES (board_seq.NEXTVAL,?,?,?)";
	private final String SQL_UPDATE = "UPDATE board SET title=?, writer=?, content=? WHERE id=?";
	private final String SQL_DELETE = "DELETE FROM board WHERE id=?";
	private final String SQL_LIST   = "SELECT * FROM board ORDER BY id DESC";
	private final String SQL_GET    = "SELECT * FROM board WHERE id=";
	
	private JdbcTemplate db;
	
	public BoardDao(DataSource source) {
		db = new JdbcTemplate(source);
	}
	
	@Override
	public void save(BoardVo vo) {
		// insert / update / delete 쿼리 를 update 로 처리할 수 있음
			
		if (vo.getId() > 0) { // update
			db.update(SQL_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getId());
		} else {
			db.update(SQL_ADD, vo.getTitle(), vo.getWriter(), vo.getContent());
		}
	}
	
	public ArrayList<BoardVo> list() {
		return (ArrayList<BoardVo>) db.query(SQL_LIST, new RowMapper<BoardVo>() {
			@Override
			public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return bind(rs);
			}
		});
	}

	@Override
	public void delete(int id) {
		db.update(SQL_DELETE, id);
	}

	@Override
	public BoardVo get(int id) {
		return (BoardVo) db.queryForObject(SQL_GET + id, new RowMapper<BoardVo>() {
			@Override
			public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return bind(rs);
			}
		});
	}
	
	private BoardVo bind(ResultSet rs) throws SQLException {
		BoardVo vo = new BoardVo();
		vo.setId(rs.getInt("id"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getDate("regdate"));
		vo.setCount(rs.getInt("count"));
		return vo;
	}
}
