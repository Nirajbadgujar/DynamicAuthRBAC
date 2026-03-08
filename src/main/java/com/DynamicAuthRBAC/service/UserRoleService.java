package com.DynamicAuthRBAC.service;

import org.springframework.stereotype.Service;

import com.DynamicAuthRBAC.entity.UserRole;
import com.DynamicAuthRBAC.repository.UserRoleRepository;

@Service
public class UserRoleService {

	private final UserRoleRepository userRoleRepository;

	public UserRoleService(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}

	public UserRole assignRoleToUser(Long userId, Long roleId) {

		UserRole userRole = new UserRole();

		userRole.setUserId(userId);
		userRole.setRoleId(roleId);

		return userRoleRepository.save(userRole);
	}
}