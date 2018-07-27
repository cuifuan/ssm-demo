package com.ceilan.controller;

import com.ceilan.dao.LocktbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class TestController {
    private final LocktbMapper locktbMapper;

    @Autowired
    public TestController(LocktbMapper locktbMapper) {
        this.locktbMapper = locktbMapper;
    }

    @RequestMapping("/dellock")
    @ResponseBody
    public Integer lock() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    locktbMapper.delLocktb(Math.round(Math.random() * 100));
//                    locktbMapper.delLocktb(locktbMapper.delLocktb(Math.random() * 100)));
                    System.out.println("time.." + new Date(System.currentTimeMillis()));
                }
            }
            ).start();
        }
        return 1;
    }

}
