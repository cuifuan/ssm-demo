package com.ceilan.controller;

import com.ceilan.dao.AreaMapper;
import com.ceilan.entity.Blog;
import com.ceilan.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final BlogService blogService;
    private final AreaMapper areaMapper;
    private static final Logger logger = LoggerFactory.getLogger(BlogController.class);

    private static int i=1;

    @Autowired
    public BlogController(BlogService blogService, AreaMapper areaMapper) {
        this.blogService = blogService;
        this.areaMapper = areaMapper;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public List<Blog> getAll(){
        return blogService.queryBlogAll();
    }

    public void startJob() {
        i++;
        System.out.println("StartJob----------第"+i+"次");
        logger.error("11111");
    }

    @RequestMapping("/card")
    public String Card(){
        return "card";
    }
    @RequestMapping("/blog")
    public String blog(){
        return "blog";
    }
}
