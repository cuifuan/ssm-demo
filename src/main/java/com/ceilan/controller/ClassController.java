package com.ceilan.controller;

import com.ceilan.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("classmap")
    @ResponseBody
    public Map queryClassMap(){
        return classService.selectClassInfo();
    }
    @RequestMapping("listmap")
    @ResponseBody
    public List<Map> listmap(){
        return classService.selectClassListMap();
    }
}
