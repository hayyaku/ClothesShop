package com.clothesshop.service;

import com.clothesshop.entities.Role;

public interface RoleService {
	Role getByRoleName(String roleName);
	void save(Role r);
}
