package com.ceilan.dao;

import com.ceilan.entity.Class;

import java.util.List;
import java.util.Map;

public interface ClassMapper {
    int insert(Class record);

    int insertSelective(Class record);
    /**
     *
     *
     * @Param []
     * @return java.util.List<java.util.Map>
     * @Author cfa  2018-07-21 
     **/
    List<Map> queryClassAll();
}