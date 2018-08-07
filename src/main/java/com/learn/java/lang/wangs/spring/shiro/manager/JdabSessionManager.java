//package com.learn.java.lang.wangs.spring.shiro.manager;
//
//import java.io.Serializable;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.springframework.util.StringUtils;
///**
// * 自定义实现sessionManager 
// * @author Adm
// *
// */
//public class JdabSessionManager extends DefaultWebSessionManager{
//
//
//    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
//
//    public final static String AUTHORIZATION = "authToken";
//    
//    public JdabSessionManager(){
//        super();
//    }
//    
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
//        //如果请求头中有 Authorization 则其值为sessionId
//        if (!StringUtils.isEmpty(id)) {
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
//            return id;
//        } else {
//            //否则按默认规则从cookie取sessionId
//            return super.getSessionId(request, response);
//        }
//    }
//    
//}
