package cn.most.esp.base.service;

import java.util.List;

import cn.most.esp.base.entity.MbInfo;

public interface MbService{

	List<MbInfo> getMbInfo(String tableName);
}
