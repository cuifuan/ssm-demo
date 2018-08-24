package org.chinaos.security;

import org.chinaos.dao.MenuMapper;
import org.chinaos.dao.RoleMapper;
import org.chinaos.dao.UserMapper;
import org.chinaos.model.Menu;
import org.chinaos.model.Role;
import org.chinaos.model.User;
import org.chinaos.util.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;


    public int updateUserPassword(User user) {
        String oldPassword = user.getPassword();
        return userMapper.updateUserSelective(user);
    }

    public int lockedUser(Integer id) {
        return userMapper.lockedByUserId(id);
    }


    public int unlockUser(Integer id) {
        return userMapper.unlockUserId(id);
    }

    /**
     * 注册用户
     * created by cfa  2018-08-06 下午 9:51
     **/
    @Transactional
    public Integer insertUser(Map map) {
        User user = new User();
        int resultid;
        user.setUsername(String.valueOf(map.get("name")));
        user.setPassword(String.valueOf(map.get("pass")));
        //如果用户名存在，返回错误
        User userlo = userMapper.loadUserByUsername(user.getUsername());
        if (userlo != null) {
            return ResultBean.USERNAME_EXIST;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
        try {
            String encode = encoder.encode(user.getPassword());
            user.setPassword(encode);
            resultid = userMapper.insertSelective(user);
        } catch (Exception e) {
            logger.error("UserService insertUser error:" + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return resultid > 0 ? ResultBean.SUCCESS : ResultBean.FAIL;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
//            throw new UsernameNotFoundException("UserServiceImpl loadUserByUsername msg:用户名错误!");
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new User();
        }
        //查询用户的角色信息，并返回存入user中
        List<Role> roles = roleMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }

    /**
     * menu菜单
     * created by cfa  2018-08-20 上午 10:39
     **/
    public List<Menu> queryHasMenu() {
        /*User user = UserUtils.getCurrentUser();
        if (user.getId() != ResultBean.NO_LOGIN) {
            List<Role> roleList = user.getRoles();
            Integer[] array = new Integer[roleList.size()];
            for (int i = 0; i < roleList.size(); i++) {
                array[i] = roleList.get(i).getId();
            }
            return menuMapper.queryHasMenu(array);
        } else {
            return null;
        }*/
        //测试版本
        return menuMapper.queryHasMenu(new Integer[]{1});
    }
}
