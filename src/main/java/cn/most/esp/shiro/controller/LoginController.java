package cn.most.esp.shiro.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.most.esp.user.entity.UserInfo;
import cn.most.esp.utils.UserUtil;

@Controller
@RequestMapping("auth")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLogin(HttpServletRequest request) {
        try {
        	String username =request.getParameter("username");
        	String password =request.getParameter("password");
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            //UserInfo user = (UserInfo) subject.getPrincipal();
        } catch (DisabledAccountException e) {
            request.setAttribute("msg", "账户已被禁用");
            return "login";
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户名或密码错误");
            return "login";
        }

        // 执行到这里说明用户已登录成功
        return "redirect:/auth/index";
    }
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String loginSuccessMessage(HttpServletRequest request) {
        String username = "未登录";
        UserInfo currentLoginUser = new UserInfo();
        currentLoginUser.setLoginname("ls");

        if (currentLoginUser != null && StringUtils.isNotEmpty(currentLoginUser.getLoginname())) {
            username = currentLoginUser.getLoginname();
        } else {
            return "redirect:/auth/login";
        }
        request.setAttribute("username", username);
        return "index";
    }

    //退出后跳转的页面
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
    	UserUtil.logout();
    	return "redirect:/auth/login";
    }
    
}
