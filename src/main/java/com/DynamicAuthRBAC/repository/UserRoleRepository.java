package com.DynamicAuthRBAC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DynamicAuthRBAC.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	List<UserRole> findByUserId(Long userId);
}
