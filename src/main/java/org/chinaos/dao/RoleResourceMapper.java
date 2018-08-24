package org.chinaos.dao;

import org.chinaos.model.Role;
import org.chinaos.model.RoleResource;

import java.util.List;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);
    /*
     * description : 查询url对应的权限
     * @return java.util.List<org.chinaos.model.Role>
     **/
    List<Role> findRolesByResourceUrl(Long id);
}