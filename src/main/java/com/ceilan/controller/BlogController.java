package com.ceilan.controller;

import com.ceilan.entity.Blog;
import com.ceilan.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author-Date： cuifuan   2018-06-11 下午 12:49
 * Description：
 */
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/hello")
    @ResponseBody
    public List<Blog> getAll(){
        return blogService.queryBlogAll();
    }
}
