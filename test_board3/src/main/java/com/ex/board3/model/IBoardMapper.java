package com.ex.board3.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IBoardMapper {
	@Insert("INSERT INTO board (id, title, writer, content) VALUES (board_seq.NEXTVAL, #{title}, #{writer}, #{content})")
	public void save(BoardVo vo);
	
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "title", column = "title"),
		@Result(property = "writer", column = "writer"),
		@Result(property = "content", column = "content"),
	})
	@Select("SELECT id, title, writer, content FROM board ORDER BY id DESC")
	public ArrayList<BoardVo> list();
	
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "title", column = "title"),
		@Result(property = "writer", column = "writer"),
		@Result(property = "content", column = "content"),
	})
	@Select("SELECT id, title, writer, content FROM board WHERE id=#{id}")
	public BoardVo get(@Param("id") int id);
	
	@Update("UPDATE board SET title=#{title}, writer=#{writer}, content=#{content} WHERE id=#{id}")
	public void update(BoardVo vo);

	@Delete("DELETE FROM board WHERE id=#{id}")
	public void delete(@Param("id") int id);
}
