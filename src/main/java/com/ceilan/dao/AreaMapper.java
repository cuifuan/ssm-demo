package com.ceilan.dao;


import java.util.List;

public interface AreaMapper {
    int insertArea(List list);
    /**
     * 查询地址
     *
     * @Param [postalcode]
     * @return java.lang.String
     * @Author cfa  2018-07-26
     **/
    String queryAreaByPostalCode(Integer postalcode);
}
