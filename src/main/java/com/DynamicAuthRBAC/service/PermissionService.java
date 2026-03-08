package com.DynamicAuthRBAC.service;

import org.springframework.stereotype.Service;

import com.DynamicAuthRBAC.entity.Permission;
import com.DynamicAuthRBAC.repository.PermissionRepository;

@Service
public class PermissionService {

	private final PermissionRepository permissionRepository;

	public PermissionService(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}

	public Permission createPermission(Permission permission) {
		return permissionRepository.save(permission);
	}

	public Permission getPermission(Long id) {
		return permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found"));
	}
}