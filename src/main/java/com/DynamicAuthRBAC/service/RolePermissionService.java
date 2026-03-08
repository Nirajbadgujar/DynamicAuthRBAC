package com.DynamicAuthRBAC.service;

import org.springframework.stereotype.Service;

import com.DynamicAuthRBAC.entity.RolePermission;
import com.DynamicAuthRBAC.repository.RolePermissionRepository;

@Service
public class RolePermissionService {

	private final RolePermissionRepository rolePermissionRepository;

	public RolePermissionService(RolePermissionRepository rolePermissionRepository) {
		this.rolePermissionRepository = rolePermissionRepository;
	}

	public RolePermission assignPermissionToRole(Long roleId, Long permissionId) {

		RolePermission rolePermission = new RolePermission();

		rolePermission.setRoleId(roleId);
		rolePermission.setPermissionId(permissionId);

		return rolePermissionRepository.save(rolePermission);
	}
}