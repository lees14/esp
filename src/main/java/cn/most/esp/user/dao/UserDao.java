package cn.most.esp.user.dao;

import cn.most.esp.base.dao.BaseDao;
import cn.most.esp.user.entity.UserInfo;

public interface UserDao extends BaseDao<UserInfo>{
	
	UserInfo getUser(UserInfo userInfo);
}
