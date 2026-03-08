package com.DynamicAuthRBAC.security;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.DynamicAuthRBAC.entity.Permission;
import com.DynamicAuthRBAC.entity.RolePermission;
import com.DynamicAuthRBAC.entity.User;
import com.DynamicAuthRBAC.entity.UserRole;
import com.DynamicAuthRBAC.repository.PermissionRepository;
import com.DynamicAuthRBAC.repository.RolePermissionRepository;
import com.DynamicAuthRBAC.repository.UserRepository;
import com.DynamicAuthRBAC.repository.UserRoleRepository;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {

		if (auth == null) {
			return false;
		}

		String username = auth.getName();

		User user = userRepository.findByUsername(username).orElse(null);

		if (user == null) {
			return false;
		}

		List<UserRole> userRoles = userRoleRepository.findByUserId(user.getId());

		for (UserRole ur : userRoles) {

			List<RolePermission> perms = rolePermissionRepository.findByRoleId(ur.getRoleId());

			for (RolePermission rp : perms) {

				Permission p = permissionRepository.findById(rp.getPermissionId()).orElse(null);

				if (p != null && p.getName().equals(permission.toString())) {
					return true;
				}
			}
		}
		System.out.println("User: " + username);
		System.out.println("Checking permission: " + permission);

		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
