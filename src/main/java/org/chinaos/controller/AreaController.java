package org.chinaos.controller;

import org.chinaos.service.AreaService;
import org.chinaos.util.HttpClientUtils;
import org.chinaos.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @RequestMapping("/getArea")
    public ResultBean getArea(@RequestBody Map<String,Integer> map){
        return areaService.getAreaAll(map);
    }
   /* @RequestMapping("/getAddress")
    public String getAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        for (int i = 1; i < 11; i++) {
        return areaService.getAddress(request,response,2);
//        }
    }*/
    @RequestMapping("/getLocation")
    public Object getLocation() throws Exception {
        String url="https://apis.map.qq.com/tools/geolocation?key=3PQBZ-BOBKD-GDQ4U-PLGJH-RFQCS-HABRO&referer=http://map.qq.com/api/js?v=2.exp";
        return HttpClientUtils.getRequest(url);
    }

}
