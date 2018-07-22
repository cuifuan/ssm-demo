package com.ceilan.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
public interface ClassService {
    /**
     * 查询班级ID和name
     *
     * @Param []
     * @return java.util.Map
     * @Author cfa  2018-07-21
     **/
    Map selectClassInfo();
    /**
     * 这里是正常的lsitmap
     *
     * @Param []
     * @return java.util.List<java.util.Map>
     * @Author cfa  2018-07-22
     **/
    List<Map> selectClassListMap();
}
