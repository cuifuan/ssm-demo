package com.ceilan.service.impl;

import com.ceilan.dao.ClassMapper;
import com.ceilan.dao.SessionMapper;
import com.ceilan.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private SessionMapper sessionMapper;
    @Autowired
    private ClassMapper classMapper;
    /**
     * 查询班级ID和name
     *
     * @return java.util.Map
     * @Param []
     * @Author cfa  2018-07-21
     **/
    @Override
    public Map selectClassInfo() {
        return sessionMapper.queryResultMaps("queryClassAll");
    }

    /**
     * 这里是正常的lsitmap
     *
     * @return java.util.List<java.util.Map>
     * @Param []
     * @Author cfa  2018-07-22
     **/
    @Override
    public List<Map> selectClassListMap() {
        return classMapper.queryClassAll();
    }
}
