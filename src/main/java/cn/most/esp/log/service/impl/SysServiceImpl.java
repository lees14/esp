package cn.most.esp.log.service.impl;

import org.springframework.stereotype.Service;

import cn.most.esp.base.service.impl.BaseServiceImpl;
import cn.most.esp.log.dao.SysinfoDao;
import cn.most.esp.log.entity.Sysinfo;
import cn.most.esp.log.service.SysService;

@Service
public class SysServiceImpl extends BaseServiceImpl<SysinfoDao, Sysinfo>
		implements SysService {

}
