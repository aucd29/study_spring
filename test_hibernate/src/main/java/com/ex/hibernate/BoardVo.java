package com.ex.hibernate;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="board")
@SequenceGenerator(name="BoardSequence", sequenceName="board_seq", initialValue=1, allocationSize=1)
public class BoardVo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BoardSequence")
	private int id;
	private String title;
	private String writer;
	private String content;
	
	@Column(name="regdate")
	private Date date;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
