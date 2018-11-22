package cn.most.esp.utils;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.most.esp.base.entity.MbInfo;
import cn.most.esp.base.service.MbService;

@Component
public class MbUtil {
	@Autowired
	private MbService mbService;
	
	private static MbUtil mbUtil;
	
	@PostConstruct
	public void init() {
		mbUtil = this;
	}
	
	public static List<MbInfo> getMbInfo(String tableName){
		return mbUtil.mbService.getMbInfo(tableName);
	}
}
