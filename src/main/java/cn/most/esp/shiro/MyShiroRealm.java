package cn.most.esp.shiro;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.most.esp.user.entity.UserInfo;
import cn.most.esp.user.service.UserService;
import cn.most.esp.utils.PasswordHelper;

public class MyShiroRealm extends AuthorizingRealm {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

	// 如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
	// @Autowired
	// private SysRoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * 登录时调用 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 *
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String name = token.getUsername();
		String password = String.valueOf(token.getPassword());
		UserInfo user = new UserInfo();
		user.setLoginname(name);
		user.setPwdmd(PasswordHelper.encryptPassword(password));
		// 从数据库获取对应用户名密码的用户
		UserInfo userList = userService.getUser(user);
		if (userList != null) {
			// 用户为禁用状态
//            if (userList.getUserEnable() != 1) {
//                throw new DisabledAccountException();
//            }
			// 单用户登录
			// 处理session
			DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
			DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
			// 获取当前已登录的用户session列表
			Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();
			UserInfo temp;
			for (Session session : sessions) {
				// 清除该用户以前登录时保存的session，强制退出
				Object attribute = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
				if (attribute == null) {
					continue;
				}
				temp = (UserInfo) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
				if (name.equals(temp.getLoginname())) {
					sessionManager.getSessionDAO().delete(session);
				}
			}

			logger.info("---------------- Shiro 凭证认证成功 ----------------------");
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userList, // 用户
					userList.getPwdmd(), // 密码
					getName() // realm name
			);

			return authenticationInfo;
		}
		throw new UnknownAccountException();
	}

	/**
	 * 
	 * @RequiresRoles({"admin"}) 时调用 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
		Object principal = principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if (principal instanceof UserInfo) {
			// UserInfo userLogin = (UserInfo) principal;

			// 加角色
			/*
			 * Set<String> roles = roleService.findRoleNameByUserId(userLogin.getId());
			 * authorizationInfo.addRoles(roles);
			 */
			authorizationInfo.addRole("user");
			authorizationInfo.addRole("admins");

			// 加权限
			/*
			 * Set<String> permissions =
			 * userService.findPermissionsByUserId(userLogin.getId());
			 * authorizationInfo.addStringPermissions(permissions);
			 */

		}
		logger.info("---- 获取到以下角色 ----");
		// logger.info(authorizationInfo.getStringPermissions().toString());
		logger.info(authorizationInfo.getRoles().toString());
		logger.info("---------------- Shiro 权限获取成功 ----------------------");
		logger.info("SessionId=" + (String) SecurityUtils.getSubject().getSession().getId());
		return authorizationInfo;
	}

}
