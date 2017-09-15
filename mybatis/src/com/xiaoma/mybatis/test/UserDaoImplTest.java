package com.xiaoma.mybatis.test;

import static org.junit.Assert.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xiaoma.mybatis.dao.UserDao;
import com.xiaoma.mybatis.dao.imp.UserDaoImpl;
import com.xiaoma.mybatis.pojo.User;

public class UserDaoImplTest {

	private SqlSessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		SqlSessionFactoryBuilder sessionFactoryBuilder =new SqlSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}

	@Test
	public void testGetUserById() {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		User user = userDao.getUserById(28);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		UserDao userDao = new UserDaoImpl(sessionFactory);
		User user =new User();
		user.setUsername("周杰伦");
		user.setAddress("台湾");
		userDao.insertUser(user);
	}

}
