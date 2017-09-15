package com.xiaoma.mybatis.first;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xiaoma.mybatis.pojo.User;

public class First {
	private SqlSessionFactory sessionFactory;

	@Before
	public void init() throws IOException {
		SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}
	
	// 根据 id查询用户信息
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sessionFactory.openSession();
		User user = sqlSession.selectOne("findUserById", 25);
		System.out.println(user);
		sqlSession.close();
	}

	// 根据 用户名模糊查询
	@Test
	public void testfindUserByUsername() {
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> list = sqlSession.selectList("findUserByUsername", "张");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	// 添加用户
	@Test
	public void testinsertUser() {
		SqlSession sqlSession = sessionFactory.openSession();
		// 添加用户信息
		User user = new User();
		user.setUsername("刘德华");
		user.setAddress("香港");
		user.setSex("1");
		user.setBirthday(new Date());
		sqlSession.insert("user.insertUser", user);
		//取生成的id
		System.out.println("取生成的主键:" + user.getId());
		//提交
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 根据 id删除用户
	@Test
	public void testdeleteUserById() {
		SqlSession sqlSession = sessionFactory.openSession();
		sqlSession.delete("deleteUserById", 28);
		sqlSession.commit();
		sqlSession.close();
	}
	
	// 根据 id修改用户
	@Test
	public void testupdateUser() {
		SqlSession sqlSession = sessionFactory.openSession();
		
		// 添加用户信息
		User user = new User();
		user.setId(28);
		user.setUsername("刘德华");
		user.setAddress("河南郑州");
		user.setSex("2");
		sqlSession.update("updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	
}
