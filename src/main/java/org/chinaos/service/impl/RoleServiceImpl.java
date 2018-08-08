package org.chinaos.service.impl;

import org.chinaos.dao.RoleMapper;
import org.chinaos.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

  /*  @Override
    public List<Role> findBySeUserId(Integer id) {
        return roleMapper.selectByExample(id);
    }

    @Override
    public Role findByType(String role) {
        return roleMapper.findByType(role);
    }

    @Override
    public List<Role> findAllRole() {
        return roleMapper.getAllRole();
    }*/
}
