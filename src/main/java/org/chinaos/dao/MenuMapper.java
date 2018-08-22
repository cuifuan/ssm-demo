package org.chinaos.dao;

import org.chinaos.model.Menu;

import java.util.List;

/**
 * Created by sang on 2017/12/28.
 */
public interface MenuMapper {
    /**
     * 查询菜单
     * created by cfa  2018-08-10 上午 12:26
     **/
    List<Menu> queryHasMenu(Integer[] ids);
}
