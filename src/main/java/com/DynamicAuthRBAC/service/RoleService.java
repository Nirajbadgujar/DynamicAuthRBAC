package com.DynamicAuthRBAC.service;

import org.springframework.stereotype.Service;

import com.DynamicAuthRBAC.entity.Role;
import com.DynamicAuthRBAC.repository.RoleRepository;

@Service
public class RoleService {

	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	public Role getRole(Long id) {
		return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
	}
}
