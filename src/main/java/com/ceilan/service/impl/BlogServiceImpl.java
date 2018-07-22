package com.ceilan.service.impl;

import com.ceilan.dao.BlogMapper;
import com.ceilan.entity.Blog;
import com.ceilan.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Author-Date： cuifuan   2018-06-11 下午 12:48
 * Description：
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> queryBlogAll() {
        List<Blog> blogList=blogMapper.queryBlogAll();
        for(Blog b:blogList){
            String str = null;
            try {
                str = new String(b.getContent(),0,b.getContent().length, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//            b.setContentblob(Base64.byteArrayToBase64(b.getContent()));
            b.setContentblob(str);
        }
        return blogList;
    }
}
