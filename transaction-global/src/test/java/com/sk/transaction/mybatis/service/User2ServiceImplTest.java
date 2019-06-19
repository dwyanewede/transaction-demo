package com.sk.transaction.mybatis.service;

import com.sk.transaction.mybatis.bean.User2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/applicationContext.xml" })
public class User2ServiceImplTest {

	@Autowired
	private User2Service user2Service;

	@Before
	public void setUpBeforeClass() throws Exception {
		user2Service.truncate();
	}

	@Test
	public void testAdd() {
		User2 user2 = new User2();
		user2.setName("李四");
		user2Service.add(user2);
	}

}