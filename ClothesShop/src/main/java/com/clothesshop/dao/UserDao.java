package com.clothesshop.dao;

import com.clothesshop.entities.User;

public interface UserDao {
	User getByUserName(String userName);
	User getByPhone(String phone);
	User getByEmail(String email);
	void save(User u);
}
