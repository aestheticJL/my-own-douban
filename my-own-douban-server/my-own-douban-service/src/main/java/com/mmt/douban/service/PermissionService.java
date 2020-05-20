package com.mmt.douban.service;

import com.mmt.douban.mapper.PermissionMapper;
import com.mmt.douban.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    public List<Permission> getAllPermissionWithRole() {
        return permissionMapper.getAllPermissionWithRole();
    }
}
