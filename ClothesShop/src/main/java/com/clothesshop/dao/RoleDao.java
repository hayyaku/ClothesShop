package com.clothesshop.dao;

import com.clothesshop.entities.Role;

public interface RoleDao {
	Role getByRoleName(String roleName);
	void save(Role r);
}
