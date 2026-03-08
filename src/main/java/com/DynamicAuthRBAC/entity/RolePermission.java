package com.DynamicAuthRBAC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RolePermission {

    @Id
    @GeneratedValue
    private Long id;

    private Long roleId;
    private Long permissionId;
}