//package com.learn.java.lang.wangs.spring.shiro.realm;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//
//public class AuthcUtils {
//	
//	// 定义认证
//	public static final String SEC_AUTHUSER = "_AUTH_";
//	public static final String SEC_ORGUNIT  = "_ORGU_";
//	public static final String SHIRO_ROLES = "_ROLE_";
//
//	static void setSession(Object key, Object value) {
//		Subject subject = SecurityUtils.getSubject();
//		if (subject.isAuthenticated()) {
//			Session session = subject.getSession();
//			session.setAttribute(key, value);
//		}
//	}
//	
//	/*
//	 * 获取认证用户
//	 */
//	@SuppressWarnings("unchecked")
//	public static <T> T getCurrentAuthUser(){
//		Subject s = SecurityUtils.getSubject();
//		if(s.isAuthenticated()){
//			Session session = s.getSession();
//			return (T) session.getAttribute(SEC_AUTHUSER);
//		}
//		return null;
//	}
//
//}
