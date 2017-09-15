package com.xiaoma.mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xiaoma.mybatis.mapper.UserMapper;
import com.xiaoma.mybatis.pojo.User;

public class UserMapperTest {

	private SqlSessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		SqlSessionFactoryBuilder sessionFactoryBuilder =new SqlSessionFactoryBuilder();
		sessionFactory = sessionFactoryBuilder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sessionFactory.openSession();
		//使用SqlSession创建一个Mapper代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testFindUserByUsername() {
		SqlSession sqlSession = sessionFactory.openSession();
		//使用SqlSession创建一个Mapper代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = mapper.findUserByUsername("张");
		System.out.println(list);
		
		
	}

}
