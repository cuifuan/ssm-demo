package org.chinaos.controller;

import org.chinaos.model.Area;
import org.chinaos.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping("/getAddress")
    public String getAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        for (int i = 1; i < 11; i++) {
         return areaService.getAddress(request,response,2);
//        }
    }

}
