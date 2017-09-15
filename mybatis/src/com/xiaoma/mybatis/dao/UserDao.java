package com.xiaoma.mybatis.dao;

import java.util.List;

import com.xiaoma.mybatis.pojo.User;

public interface UserDao {
	
	public User getUserById(int id);
	public void insertUser(User user);

}
