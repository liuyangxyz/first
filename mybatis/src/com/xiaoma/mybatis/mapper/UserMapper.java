package com.xiaoma.mybatis.mapper;

import java.util.List;

import com.xiaoma.mybatis.pojo.User;

public interface UserMapper {
	
	public User findUserById(int ID);
	
	public List<User> findUserByUsername(String name);

}
