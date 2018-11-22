package cn.most.esp.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.most.esp.base.dao.MbDao;
import cn.most.esp.base.entity.MbInfo;
import cn.most.esp.base.service.MbService;

@Service
public class MbServiceImpl implements MbService{

	@Autowired
	private MbDao mbDao;

	@Override
	public List<MbInfo> getMbInfo(String tableName) {
		List<MbInfo> list = mbDao.getMb(tableName);
		return list;
	}
	
}
