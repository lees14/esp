package cn.most.esp.log.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.most.esp.log.entity.Sysinfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysServiceImplTest {

	@Autowired
	private SysServiceImpl sysServiceImpl;
	
	@Test
	public void testInsert() {

		Sysinfo sysinfo = new Sysinfo();
		sysinfo.setSlogname("lis");
		sysinfo.setSaction("101");
		sysServiceImpl.insert(sysinfo);
	}

}
