package com.ceilan.dao;

import com.ceilan.entity.Blog;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);
    /**
     * description:查询全部博客
     * @param []
     * @return java.util.List<Blog>
     * @author cuifuan  2018-06-11 下午 12:47
     */
    List<Blog> queryBlogAll();
}