package com.example.travel.service.Impl;

import com.example.travel.jpa.Comment;
import com.example.travel.jpa.Role;
import com.example.travel.repository.RoleRepository;
import com.example.travel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        try{
            List<Role> roles = roleRepository.findAll();
            return  roles;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role insertRole(Role role) {
        try{
            roleRepository.save(role);
            return role;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean saveRole(Role role) {
        try{
            roleRepository.save(role);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
