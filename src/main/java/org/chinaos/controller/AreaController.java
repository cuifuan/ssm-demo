package org.chinaos.controller;

import org.chinaos.model.Area;
import org.chinaos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @RequestMapping("/getArea")
    public List<Area> getArea(){
        return areaService.getAreaAll();
    }
}
