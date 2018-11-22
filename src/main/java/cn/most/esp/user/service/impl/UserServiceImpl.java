package cn.most.esp.user.service.impl;

import org.springframework.stereotype.Service;

import cn.most.esp.base.service.impl.BaseServiceImpl;
import cn.most.esp.user.dao.UserDao;
import cn.most.esp.user.entity.UserInfo;
import cn.most.esp.user.service.UserService;
import cn.most.esp.utils.PasswordHelper;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserInfo> implements UserService{

	@Override
	public UserInfo getUser(UserInfo userInfo) {
		return dao.getUser(userInfo);
	}
	
	@Override
	//@Transactional  //事务
	public int insert(UserInfo t) {
		t.setPwdmd(PasswordHelper.encryptPassword(t.getPwdmd()));
		return super.insert(t);
	}

}
