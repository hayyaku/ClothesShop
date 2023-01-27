package com.clothesshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.RoleDao;
import com.clothesshop.entities.Role;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getByRoleName(String roleName) {
		return roleDao.getByRoleName(roleName);
	}

	@Override
	public void save(Role r) {
		roleDao.save(r);
		
	}

}
