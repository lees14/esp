package cn.most.esp.utils;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.most.esp.log.entity.Sysinfo;
import cn.most.esp.log.service.SysService;

@Component
public class LogUtil {

	@Autowired
	private SysService sysService;

	private static LogUtil logUtil;

	@PostConstruct
	public void init() {
		logUtil = this;
	}

	public static void saveLog(HttpServletRequest request,String action) {

		Sysinfo sysinfo = new Sysinfo();
		sysinfo.setSlogname(UserUtil.getUser().getLoginname());
		sysinfo.setSuid(String.valueOf(UserUtil.getUserId()));
		sysinfo.setSaction(action);
		sysinfo.setSip(getIpAddr(request));
		sysinfo.setStime(new Date());
		logUtil.sysService.insert(sysinfo);
	}

	/**
	 * 获取登录用户远程主机ip地址
	 * 
	 * @param request
	 * @return
	 */
	private static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
