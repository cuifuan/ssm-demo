package org.chinaos.dao;

import org.chinaos.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int unlockUserId(Integer id);

    int lockedByUserId(Integer id);

    List<User> getAllByPage();

    int updateUserSelective(User user);

    User loadUserByUsername(String username);
}