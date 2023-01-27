package com.clothesshop.service;

import com.clothesshop.dto.UserDto;
import com.clothesshop.entities.User;

public interface UserService {
	User getByUserName(String userName);
	User getByPhone(String phone);
	User getByEmail(String email);
	User save(String fullname,String email,String phone,String username, String password);
	UserDto checkAccount(UserDto userDto);
}
