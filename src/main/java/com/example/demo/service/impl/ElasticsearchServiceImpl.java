package com.example.demo.service.impl;

import com.example.demo.dto.User;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ElasticsearchService;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Date 2020/4/16 10:45
 * @Author 86131
 * @Description
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> queryLikeFormUser(String searchKey) {
        List<User> list = new ArrayList<>();
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchKey);

        //  重点是下面这行代码
        builder.analyzer("myanalyzer").field("username").field("password").field("ip");
        Iterable<User> search = userRepository.search(builder);
        Iterator<User> iterator = search.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
