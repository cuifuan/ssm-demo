package org.chinaos.service;

import org.chinaos.model.Menu;

import java.util.List;

/**
 * 菜单接口
 * created by cfa  2018-08-02 下午 3:24
 **/
public interface MenuService {
    /**
     * 查询各级导航
     * created by cfa  2018-08-23 下午 2:14
     **/
    List<Menu> getMenuByParentid(Integer parentid);
}
