package com.ex.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	
	private static SessionFactory sf;

	static {
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	public static Session getCurrentSession() {
		return sf.getCurrentSession();
	}

	public static void closeSession() {
		sf.close();
	}

	public static Transaction beginTransaction() {
		return sf.getCurrentSession().beginTransaction();
	}

	public static void commitTransaction() {
		sf.getCurrentSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		if (sf.getCurrentSession().isOpen()) {
			Transaction tx = sf.getCurrentSession().getTransaction();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
	}
}
