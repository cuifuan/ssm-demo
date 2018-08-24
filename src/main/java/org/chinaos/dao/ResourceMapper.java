package org.chinaos.dao;

import org.chinaos.model.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKeyWithBLOBs(Resource record);
    /*
     * description : 查询所有地址
     * @return java.util.List<org.chinaos.model.Resource>
     **/
    List<Resource> findAll();
}