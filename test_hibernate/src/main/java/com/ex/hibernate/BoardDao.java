package com.ex.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	public List<BoardVo> list() {
		Session ss = HibernateUtil.getCurrentSession();
		ss.beginTransaction();
		List<BoardVo> list = ss.createQuery("from BoardVo ORDER BY id DESC").list();
		ss.getTransaction().commit();

		return list;
	}
	
	public void save(BoardVo vo) {
		Session ss = HibernateUtil.getCurrentSession();
		
		try {
			ss.beginTransaction();
			ss.save(vo);
			ss.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			ss.getTransaction().rollback();
		} finally {
		}
	}
}
