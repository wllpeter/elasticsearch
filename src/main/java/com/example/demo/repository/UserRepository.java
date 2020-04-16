package com.example.demo.repository;


import com.example.demo.dto.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wll
 * @Description
 * @create 2020-04-16 23:20
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {
}
