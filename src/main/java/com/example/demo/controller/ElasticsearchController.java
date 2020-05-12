package com.example.demo.controller;

import com.example.demo.service.ElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Date 2020/4/16 10:43
 * @Author 86131
 * @Description
 */
@RequestMapping("/search")
@RestController
public class ElasticsearchController {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @GetMapping("/queryLikeFormUser")
    public Object queryLikeFormUser(@RequestParam String searchKey) {
        return elasticsearchService.queryLikeFormUser(searchKey);
    }


}
