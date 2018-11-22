package cn.most.esp.base.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.most.esp.base.entity.MbInfo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MbServiceImplTest {

	@Autowired
	private MbServiceImpl mbServiceImpl;
	
	@Test
	public void test() {
		List<MbInfo> list = mbServiceImpl.getMbInfo("t_m_hdlx");
		System.out.println(list.get(0).getSname());
	}

}
