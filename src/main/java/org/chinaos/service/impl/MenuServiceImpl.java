package org.chinaos.service.impl;

import org.chinaos.dao.MenuMapper;
import org.chinaos.model.Menu;
import org.chinaos.model.MyUserDetails;
import org.chinaos.model.Role;
import org.chinaos.service.MenuService;
import org.chinaos.util.ResultBean;
import org.chinaos.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Menu> queryHasMenu() {
         MyUserDetails myUserDetails = UserUtils.getCurrentUser();
        if (myUserDetails.getId() != ResultBean.NO_LOGIN) {
            List<Role> roleList = myUserDetails.getRoles();
            Integer[] array = new Integer[roleList.size()];
            for (int i = 0; i < roleList.size(); i++) {
                array[i] = roleList.get(i).getId();
            }
            return menuMapper.queryHasMenu(array);
        } else {
            return new ArrayList<>();
        }
        //测试版本
//        return menuMapper.queryHasMenu(new Integer[]{1});
    }
}
