package org.chinaos.service;

import org.chinaos.model.Menu;

import java.util.List;

/**
 * 菜单接口
 * created by cfa  2018-08-02 下午 3:24
 **/
public interface MenuService {

    List<Menu> getAllMenu();

    List<Menu> getMenusByUserId();

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
