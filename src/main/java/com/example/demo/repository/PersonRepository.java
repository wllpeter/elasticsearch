package com.example.demo.repository;

import com.example.demo.dto.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wll
 * @Description
 * @create 2020-04-16 22:59
 */
@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
}
