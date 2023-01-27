package com.clothesshop.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	
	private static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	public void add(HttpServletRequest servletRequest,String key,Object value) {
		servletRequest.getSession().setAttribute(key, value);
	}
	
	public Object get(HttpServletRequest servletRequest,String key) {
		
		return servletRequest.getSession().getAttribute(key);
	}
	
	public void remove(HttpServletRequest servletRequest,String key) {
		servletRequest.getSession().removeAttribute(key);
	}
}
