package com.xiaoma.mybatis.dao.imp;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xiaoma.mybatis.dao.UserDao;
import com.xiaoma.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	
	//注入SqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory=sqlSessionFactory;
	}

	@Override
	public User getUserById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("user.findUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

}
