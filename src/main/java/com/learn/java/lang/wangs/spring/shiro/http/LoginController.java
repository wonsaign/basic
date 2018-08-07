//package com.learn.java.lang.wangs.spring.shiro.http;
//
//import java.lang.reflect.Member;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
//
//import javax.security.auth.Subject;
//import javax.security.sasl.AuthenticationException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.alibaba.fastjson.JSON;
//import com.learn.java.lang.wangs.spring.shiro.bean.ShiroBean;
//import com.learn.java.lang.wangs.spring.shiro.realm.AuthcUtils;
//import com.learn.java.lang.wangs.util.HttpUtil;
//import com.learn.java.lang.wangs.util.QString;
//
//public abstract class LoginController {
//	static Logger logger = LoggerFactory.getLogger(LoginController.class);
//	
//	final static String RESP_MESS = "message_login";
//	
//	private final String success = "success";
//	
//	private final String fail = "fail";
//
//	@Autowired
////	private MemberService memberService;
//
//	/**
//	 * 业务处理
//	 * @param request
//	 * @return
//	 */
//	public ShiroBean authUserLogin(HttpServletRequest request) {
//		//已经登录
//		if(!QString.isNullOrEmpty(request.getRemoteUser())){
//			return new ShiroBean(true,success);
//		}
//		//未登录
//		String username = request.getParameter("username");
//		String pwd = request.getParameter("password");
//		// 
//		UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
//		token.setRememberMe(false);
//		
//		boolean result = false;
//		// 获取当前的Subject
//		Subject subject = SecurityUtils.getSubject();
//		try {
//			subject.login(token);
//			Member member = memberService.getByAccount(username);
//			HttpSession session = request.getSession();
//			session.setAttribute(AuthcUtils.SEC_AUTHUSER, member);
//			result = true;
//			
//			return new ShiroBean(result,JSON.toJSON(subject.getSession().getId()));
//		} catch (UnknownAccountException uae) {
//			request.setAttribute(RESP_MESS, "未知账户");
//		} catch (IncorrectCredentialsException ice) {
//			request.setAttribute(RESP_MESS, "密码不正确");
//		} catch (LockedAccountException lae) {
//			request.setAttribute(RESP_MESS, "账户已锁定");
//		} catch (ExcessiveAttemptsException eae) {
//			request.setAttribute(RESP_MESS, "用户名或密码错误次数过多");
//		} catch (AuthenticationException ae) {
//			request.setAttribute(RESP_MESS, "用户名或密码不正确");
//		} catch (Exception e){
//			request.setAttribute(RESP_MESS, "未知账户");
//		}
//		System.out.println(request.getAttribute(RESP_MESS));
//		// 验证是否登录成功
//		if (!subject.isAuthenticated()) {
//			token.clear();
//		}
//		return new ShiroBean(result,fail);
//		
//	}
//
//	/**
//	 * 注销退出<p>
//	 * 注销时，使用线程处理，实际发现阻塞
//	 * @param request
//	 * @return
//	 */
//	protected void logout(HttpServletRequest request) {
//		final Subject subject = SecurityUtils.getSubject();
//		// Remove Session
//		HttpUtil.removeAllAttr(request.getSession());
//		try {
//			@SuppressWarnings("rawtypes")
//			Callable<?> task = new Callable(){
//				@Override
//				public Object call() throws Exception {
//					subject.logout();
//					return null;
//				}
//			};
//			@SuppressWarnings("unchecked")
//			Future<Integer> future = (Future<Integer>) Executors.newSingleThreadExecutor().submit(task);
//			future.get(88, TimeUnit.MILLISECONDS);
//		} catch (Exception e) {
//			logger.warn("Logout error {}", e.getMessage());
//		}
//		//return "redirect:InternalResourceViewResolver.REDIRECT_URL_PREFIX + \";
//	}
//}
