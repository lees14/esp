package cn.most.esp.user.service;

import cn.most.esp.base.service.BaseService;
import cn.most.esp.user.entity.UserInfo;

public interface UserService extends BaseService<UserInfo>{

	UserInfo getUser(UserInfo userInfo);
	
}
