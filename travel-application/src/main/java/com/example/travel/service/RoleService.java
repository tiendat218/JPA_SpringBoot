package com.example.travel.service;

import com.example.travel.jpa.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role insertRole(Role role);
    boolean saveRole(Role role);
}
