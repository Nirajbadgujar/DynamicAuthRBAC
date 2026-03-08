package com.DynamicAuthRBAC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DynamicAuthRBAC.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

	List<RolePermission> findByRoleId(Long roleId);
}