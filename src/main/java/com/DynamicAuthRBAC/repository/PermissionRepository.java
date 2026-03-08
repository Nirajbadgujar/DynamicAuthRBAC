package com.DynamicAuthRBAC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DynamicAuthRBAC.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}