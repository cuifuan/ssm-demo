package org.chinaos.service.impl;

import org.chinaos.dao.MenuMapper;
import org.chinaos.model.Menu;
import org.chinaos.service.MenuService;
import org.chinaos.util.UserUtils;
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

    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    @Override
    public List<Menu> getMenusByUserId() {
        return menuMapper.getMenusByUserId(UserUtils.getCurrentHr().getId());
    }

    @Override
    public List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    @Override
    public List<Long> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
