package org.chinaos.controller;

import org.chinaos.service.MenuService;
import org.chinaos.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单的控制器
 * created by cfa  2018-08-23 下午 2:17
 * 4.0往上
 * RestController 使当前类返回的都是json格式，省去各方法前的ResponseBosy注解
 **/
@RestController
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public ResultBean getMenu(@RequestParam(value = "id", defaultValue = "-1") Integer id) {
        return new ResultBean<>(menuService.getMenuByParentid(id));
    }

}
