package org.chinaos.controller;

import org.chinaos.util.HttpClientUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用API
 * created by cfa  2018-08-23 下午 3:09
 **/
@RestController
public class ApiClient {
    private static final String news = "https://www.apiopen.top/journalismApi";

    @GetMapping("/news")
    public Object news() {
        return HttpClientUtils.getRequest(news);
    }
}
