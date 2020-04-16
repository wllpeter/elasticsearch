package com.example.demo.repository;

import com.example.demo.dto.Library;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Date 2020/4/16 10:24
 * @Author 86131
 * @Description
 */
@Repository
public interface LibraryRepository extends ElasticsearchRepository<Library, Long> {
}
