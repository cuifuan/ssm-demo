package org.chinaos.service.impl;

import org.chinaos.dao.MenuMapper;
import org.chinaos.model.Menu;
import org.chinaos.service.MenuService;
import org.chinaos.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    @Override
    public List<Menu> getMenuByParentid(Integer parentid) {
        return menuMapper.getMenuByParentid(parentid);
    }
}
