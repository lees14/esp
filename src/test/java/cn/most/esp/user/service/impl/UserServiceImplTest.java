package cn.most.esp.user.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.most.esp.user.dao.UserDao;
import cn.most.esp.user.entity.UserInfo;
import cn.most.esp.utils.PasswordHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testGetAll() {
		List<UserInfo> list = userDao.getAll();
		System.out.println(list);
		
	}

	@Test
	public void insert() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setLoginname("lis1");
		userInfo.setPwdmd(PasswordHelper.encryptPassword("12345678"));
		userDao.insert(userInfo);
	}
}
