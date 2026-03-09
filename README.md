Dynamic Authorization RBAC System (Spring Boot)
This project demonstrates a dynamic Role-Based Access Control (RBAC) system using Spring Boot and Spring Security.
Instead of hardcoding roles or authorities inside the application, permissions are stored in the database and evaluated dynamically at runtime.

The system uses a custom PermissionEvaluator to verify whether a user has permission to access a specific API.

1. Architecture Overview

The system uses the following core entities:
-User
-Role
-Permission
-UserRole
-RolePermission

Explanation:

User → assigned to Roles
Role → assigned Permissions
Permission → allows access to APIs

2. Authorization Flow

- The authorization process follows this sequence:

Client Request
     ↓
Spring Security Authentication (Basic Auth)
     ↓
Authenticated User
     ↓
@PreAuthorize Annotation
     ↓
Custom PermissionEvaluator
     ↓
Database Permission Lookup
     ↓
Access Granted / Access Denied

- Example request flow:

GET /api/secure-data
     ↓
Spring Security authenticates user
     ↓
@PreAuthorize("hasPermission(null,'ACCESS_SECURE_DATA')")
     ↓
CustomPermissionEvaluator checks DB
     ↓
Permission found → Access granted

3. Permission Evaluation Logic

The permission check works as follows:

Identify the authenticated user

Retrieve roles assigned to the user

Retrieve permissions assigned to those roles

Check if the required permission exists

Simplified Logic
User → Roles → Permissions → API Access

Example:

User: niraj
Role: ADMIN
Permission: ACCESS_SECURE_DATA

When the user calls:

GET /api/secure-data

The system checks if the permission exists.

If yes → request allowed.

5. Why Hardcoded Roles Are Avoided

Hardcoding roles like this is not scalable:

@PreAuthorize("hasRole('ADMIN')")

Problems:

Requires code changes for new roles

Requires redeployment

Not flexible for large systems

Dynamic RBAC advantages:

Roles stored in DB
Permissions stored in DB
Admin can update access without code changes

6. Example Permission Checks

Example protected API:

@PreAuthorize("hasPermission(null,'ACCESS_SECURE_DATA')")
@GetMapping("/secure-data")
public String getSecureData(){
    return "This is protected data";
}

Permission required:

ACCESS_SECURE_DATA
