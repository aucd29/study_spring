package com.ex.board2.db;

import java.util.ArrayList;

import com.ex.board2.data.BoardVo;

public interface IBoardDao {
	public void save(BoardVo vo);
	public void delete(int id);
	public BoardVo get(int id);
	public ArrayList<BoardVo> list();
}
