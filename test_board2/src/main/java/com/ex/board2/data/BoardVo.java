package com.ex.board2.data;

import java.sql.Date;

public class BoardVo {
	private int id;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int count;
	
	public BoardVo() {
		
	}
	
	public BoardVo(String title, String writer, String content, int cnt) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.count = cnt;
	}
	
	// http://stackoverflow.com/questions/25272543/no-default-constructor-found-nested-exception-is-java-lang-nosuchmethodexceptio
	public BoardVo(int id, String title, String writer, String content, int cnt) {
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.count = cnt;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int cnt) {
		this.count = cnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
