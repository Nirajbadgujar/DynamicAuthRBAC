package com.DynamicAuthRBAC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.DynamicAuthRBAC.entity.Permission;
import com.DynamicAuthRBAC.entity.Role;
import com.DynamicAuthRBAC.entity.RolePermission;
import com.DynamicAuthRBAC.entity.User;
import com.DynamicAuthRBAC.entity.UserRole;
import com.DynamicAuthRBAC.repository.UserRepository;
import com.DynamicAuthRBAC.service.PermissionService;
import com.DynamicAuthRBAC.service.RolePermissionService;
import com.DynamicAuthRBAC.service.RoleService;
import com.DynamicAuthRBAC.service.UserRoleService;
import com.DynamicAuthRBAC.service.UserService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	UserRoleService userRoleService;

	@Autowired
	RoleService roleService;

	@Autowired
	PermissionService permissionService;

	@Autowired
	RolePermissionService rolePermissionService;

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public User createUser(@RequestBody User user) {

		return userService.createUser(user);
	}

	@PreAuthorize("hasPermission(null,'CREATE_ROLE')")
	@PostMapping("/roles")
	public Role createRole(@RequestBody Role role) {
		return roleService.createRole(role);
	}

	@PreAuthorize("hasPermission(null,'CREATE_PERMISSION')")
	@PostMapping("/permissions")
	public Permission createPermission(@RequestBody Permission permission) {
		return permissionService.createPermission(permission);
	}

	@PreAuthorize("hasPermission(null,'ASSIGN_PERMISSION')")
	@PostMapping("/roles/{roleId}/permissions/{permissionId}")
	public RolePermission assignPermission(@PathVariable Long roleId, @PathVariable Long permissionId) {

		return rolePermissionService.assignPermissionToRole(roleId, permissionId);
	}

	@PreAuthorize("hasPermission(null,'ASSIGN_ROLE')")
	@PostMapping("/users/{userId}/roles/{roleId}")
	public UserRole assignRole(@PathVariable Long userId, @PathVariable Long roleId) {

		return userRoleService.assignRoleToUser(userId, roleId);
	}

	@PreAuthorize("hasPermission(#niraj,'ACCESS_SECURE_DATA')")
	@GetMapping("/secure-data")
	public String getSecureData(Authentication auth) {

		String username = auth.getName();

		return "Sensitive data accessed by: " + username;
	}
}
