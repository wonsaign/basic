//package com.learn.java.lang.wangs.spring.shiro.realm;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.pam.UnsupportedTokenException;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.jdab.platform.model.Member;
//import com.jdab.platform.service.MemberService;
//import com.jdab.platform.service.RoleService;
//import com.jdab.platform.utils.common.MD5Util;
//import com.jdab.platform.utils.common.QString;
//
///**
// * http://shiro.apache.org/spring.html
// */
//public class JdabRealm extends AuthorizingRealm {
//
//	static Logger logger = LoggerFactory.getLogger(JdabRealm.class);
//	
//	//public static final Map<String , Member> authMember = new ConcurrentHashMap<>();
//
//	@Autowired
//	private MemberService memberService;
//	@Autowired
//	RoleService roleService;
//	
//	// 授权
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		// 0.get from subject PrincipalCollection
//		String username = (String) getAvailablePrincipal(principals);
//		SimpleAuthorizationInfo authInfo = null;
//
//		// 1.get use`roles by user`s username from related table
//		String roleCode = memberService.getByAccount(username).getRoleCode();
//		
//		if(!QString.isNullOrEmpty(roleCode) && roleService.getByCode(roleCode) != null){
//			String role = roleService.getByCode(roleCode).getRoleRoot();
//			Set<String> roles = new HashSet<String>();
//			roles.add(role);
//			
//			// 2.to grant authorizationInfo to this user
//			authInfo = new SimpleAuthorizationInfo();
//			authInfo.addRoles(roles);
//		}
//		return authInfo;
//	}
//
//	// 认证
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//		// 0.get token from httpReq `s UsernamePasswordTocken
//		if (token == null) {
//			throw new UnsupportedTokenException("身份令牌为空");
//		}
//		String username = (String) token.getPrincipal();
//		Object credentials = token.getCredentials();
//		if (credentials == null) {
//			throw new IncorrectCredentialsException("凭证为空");
//		}
//		String password = new String((char[]) credentials);
//		// 1, get data from database
//		Member member = memberService.getByAccount(username);
//		// 2, Md5 decry
//		if(!MD5Util.md5Low(password).equals(member.getUserPassword())){
//			throw new IncorrectCredentialsException("密码不正确");
//		}
//		
//		SimpleAuthenticationInfo authInfo;
//		authInfo = new SimpleAuthenticationInfo(username, password, username);
//
//		AuthcUtils.setSession(AuthcUtils.SEC_AUTHUSER, member);// 设置认证用户
//		//RoleServiceManager roleServiceManager = AppContext.getBean(RoleServiceManager.class);
//		//AuthcUtils.setSession(AuthcUtils.SHIRO_ROLES, roleServiceManager.getRoles().get(member.getRoleCode()).getRoleRoot());// 设置角色权限
//		return authInfo;
//	}
//}
