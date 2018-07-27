package com.ceilan.dao;

import com.ceilan.entity.Locktb;

public interface LocktbMapper {
    int insert(Locktb record);

    int insertSelective(Locktb record);
    /**
     * 
     *
     * @Param [age]
     * @return java.lang.Integer
     * @Author cfa  2018-07-27
     **/
    Integer delLocktb(Long age);
}