package cn.most.esp.zjxx.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.most.esp.zjxx.entity.ZjxxInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZjxxServiceImplTest {

	@Autowired
	private ZjxxServiceImpl zjxxServiceImpl;
	
	@Test
	public void testInsert() {
		ZjxxInfo zjxxInfo = new ZjxxInfo();
		zjxxInfo.setZid(1);
		zjxxInfo.setZjxm("ls");
		zjxxInfo.setZjxb("男");
		zjxxServiceImpl.insert(zjxxInfo);
	}


	@Test
	public void testUpdateById() {
		ZjxxInfo zjxxInfo = new ZjxxInfo();
		zjxxInfo.setZid(1);
		zjxxInfo.setZjxm("lis");
		zjxxServiceImpl.updateById(zjxxInfo);
		System.out.println(zjxxServiceImpl.getOneById(1).getZjxm());
	}

	@Test
	public void testGetOneById() {
		ZjxxInfo zjxxInfo = zjxxServiceImpl.getOneById(1);
		System.out.println(zjxxInfo.getZjxm());
	}


}
