package com.example.demo.service;

import com.example.demo.dto.User;

import java.util.List;

/**
 * @Date 2020/4/16 10:45
 * @Author 86131
 * @Description
 */
public interface ElasticsearchService {
    List<User> queryLikeFormUser(String searchKey);
}
