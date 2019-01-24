//package com.learn.java.lang.wangs.spring.shiro.filter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//import org.apache.shiro.web.util.WebUtils;
///**
// * 自定义实现请求方式过滤
// * @author Adm
// *
// */
//public class JdabFormAuthenticationFilter extends FormAuthenticationFilter {
//	
//    @Override
//	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//    	boolean allowed = super.isAccessAllowed(request, response, mappedValue);
//    	//判断请求是否是options请求
//    	if (!allowed && StringUtils.equalsIgnoreCase("OPTIONS", WebUtils.toHttp(request).getMethod()))
//    		return true;
//    	return allowed;
//    }
//
//    // 若认证不通过，返回相应
//    @Override
//    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//        // 获取当前登录
//        Subject subject = getSubject(request, response);  
//        if (subject.getPrincipal() == null) { 
//            // 使用response响应流返回数据到前台（因前端需要接受json数据，注意前后端跨域问题）
//        	return false;
//        } 
//        return true;
//    }
//}
