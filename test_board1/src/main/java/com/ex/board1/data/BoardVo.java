package com.ex.board1.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class BoardVo {
	private int seq;
	private String title;
	private String writer;
	private int cnt;
	
	// http://stackoverflow.com/questions/25272543/no-default-constructor-found-nested-exception-is-java-lang-nosuchmethodexceptio
	public BoardVo(int seq, String title, String writer, int cnt) {
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.cnt = cnt;
	}
	
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
