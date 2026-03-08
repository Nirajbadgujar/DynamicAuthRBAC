package com.DynamicAuthRBAC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long roleId;
}