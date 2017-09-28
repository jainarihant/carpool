package com.utility;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	private static Session session;
	@SuppressWarnings("deprecation")
	public static Session getSession(){
		session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		return session;
	}
}
