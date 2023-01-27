package com.clothesshop.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.RoleDao;
import com.clothesshop.dao.UserDao;
import com.clothesshop.dto.UserDto;
import com.clothesshop.entities.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Override
	public User getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	@Override
	public User save(String fullname,String email,String phone,String username,String password) {
		User newUser = new User();
		newUser.setFullName(fullname);
		newUser.setEmail(email);
		newUser.setPhone(phone);
		newUser.setUserName(username);
		newUser.setPassWord(BCrypt.hashpw(password, BCrypt.gensalt(12)));
		newUser.setRoleId(roleDao.getByRoleName("user"));
		userDao.save(newUser);
		return newUser;		
	}

	@Override
	public User getByPhone(String phone) {
		return userDao.getByPhone(phone);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}


	@Override
	public UserDto checkAccount(UserDto userDto) {
		User user = userDao.getByUserName(userDto.getUserName());
		if(user != null) {
			if(BCrypt.checkpw(userDto.getPassWord(), user.getPassWord())) {
				UserDto userDtoRp = new UserDto();
				userDtoRp.setEmail(user.getEmail());
				userDtoRp.setFullName(user.getFullName());
				userDtoRp.setPhone(user.getPhone());
				userDtoRp.setUserName(user.getUserName());
				userDtoRp.setRole(user.getRoleId().getName());
				return userDtoRp;
			}
			return null;
		}
			return null;
	}
	
	

}
