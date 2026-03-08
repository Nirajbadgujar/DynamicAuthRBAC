package com.DynamicAuthRBAC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DynamicAuthRBAC.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}