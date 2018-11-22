package cn.most.esp.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;

import cn.most.esp.shiro.MyShiroRealm;
import cn.most.esp.user.entity.UserInfo;

public class UserUtil {
	
	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}
	/**
	 * 获取当前用户信息
	 * @return
	 */
	public static UserInfo getUser() {
		try {
			Object object = getSubjct().getPrincipal();
			if (null == object)
				throw new UnauthenticatedException();
			return (UserInfo) object;
		} catch (Exception e) {
			throw new UnauthenticatedException("");
		}
	}

	/**
	 * 获取用户id
	 * @return
	 */
	public static int getUserId() {
		return getUser().getId();
	}

	/**
	 * 退出登录
	 */
	public static void logout() {
		getSubjct().logout();
	}
	/**
	 * 刷新用户角色权限
	 */
	public static void cleanCash() {
		RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		// MyShiroRealm为在项目中定义的realm类
		MyShiroRealm shiroRealm = (MyShiroRealm) rsm.getRealms().iterator().next();
		Subject subject = SecurityUtils.getSubject();
//	        String realmName = subject.getPrincipals().getRealmNames().iterator().next();
//	        SimplePrincipalCollection principals = new SimplePrincipalCollection(subject.getPrincipals(),realmName);
//	        subject.runAs(principals);
		// 用realm删除principle
		shiroRealm.getAuthorizationCache().remove(subject.getPrincipals());
	}
}
