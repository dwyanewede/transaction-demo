package com.sk.transaction.mybatis.service;

import com.sk.transaction.mybatis.bean.User1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
class User1ServiceImplTest {

	@Autowired
	private User1Service user1Service;

	@Before
	public void setUpBeforeClass() throws Exception {
		user1Service.truncate();
	}

	@Test
	public void testAdd() {
		User1 user1 = new User1();
		user1.setName("张三");
		user1Service.add(user1);
	}

}